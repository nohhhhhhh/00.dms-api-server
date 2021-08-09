package com.dms.api.service.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.MenuMasterDto;
import com.dms.api.dto.setting.UserMasterDto;
import com.dms.entitiy.CmMenuMEntity;
import com.dms.repository.setting.MenuMasterRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Auth Check Controller.
 *
 * @author NOH
 * @since 1.0
 *
 */
@Service
public class MenuMasterService {

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private MenuMasterRepository menuMasterRepository;

  public int status = 500;
  public String message;
  public Map<String, Object> resultData;
  public List<?> resultList;

  /**
   * Top Menu Item Api of AuthorizedUser.
   *
   * @author NOH
   * @since 1.0
   *
   */
  public ResponseEntity<Response> getTopItems(AuthorizedUser authorizedUser, String useYn,
      String plantId) {

    resultData = new HashMap<String, Object>();

    UserMasterDto userMasterDto = new UserMasterDto();
    userMasterDto.setUserId(authorizedUser.getUserId());
    userMasterDto.setUseYn(useYn);
    userMasterDto.setPlantId(plantId);

    var minMenuLevel = menuMasterRepository.selectMinMaxLevel(userMasterDto).get()
        .getMinMenuLevel();
    var maxMenuLevel = menuMasterRepository.selectMinMaxLevel(userMasterDto).get()
        .getMaxMenuLevel();
    var parentMenuId = "";

    List<MenuMasterDto> menuList = new ArrayList<>();

    menuList = getUserAuthMenus(userMasterDto, menuList, minMenuLevel, maxMenuLevel, minMenuLevel,
        parentMenuId);

    resultData.put("userAuthMenuList", menuList);

    Response response = new Response(resultData);

    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

  /**
   * Check Select Menu Auth.
   *
   * @author NOH
   * @since 1.0
   *
   */
  public ResponseEntity<Response> checkMenuAuth(UserMasterDto userMasterDto,
      MenuMasterDto menuMasterDto) throws Exception {

    userMasterDto.setUserId("noh");
    userMasterDto.setPlantId("AS2N");
    userMasterDto.setUseYn("Y");

    try {
      status = 200;
      message = "HttpStatus.OK";
      resultData = new HashMap<String, Object>();
      List<CmMenuMEntity> selectPartMenuList = new ArrayList<>(); //navi todo
      var maxMenuLevel = menuMasterRepository.selectMinMaxLevel(userMasterDto).get()
          .getMaxMenuLevel();

      var parentMenuId = "";

      List<MenuMasterDto> menuInfo = menuMasterRepository
          .selectAuthMenuListByOption(userMasterDto, maxMenuLevel, null, menuMasterDto.getMenuId());

      if (menuInfo.size() > 0) {
        resultData.put("menuInfo", menuInfo.get(0));

      } else {
        message = "메뉴의 접근 정보가 유효하지 않습니다. 권한을 추가하여야 합니다.";
      }

    } catch (Exception e) {
      message = e.getMessage();
    }

    Response response = new Response(status, message, resultData);

    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

  private List<MenuMasterDto> getUserAuthMenus(UserMasterDto userMasterDto,
      List<MenuMasterDto> menuList,
      int minMenuLevel,
      int maxMenuLevel,
      int searchMenuLevel,
      String parentMenuId) {

    // 1depth
    if (minMenuLevel == searchMenuLevel) {
      menuList = menuMasterRepository
          .selectAuthMenuListByOption(userMasterDto, searchMenuLevel, parentMenuId, null);
    }

    for (int i = 0; i < menuList.size(); i++) {
      // 1.menuList 의 자식 요소 조회// 1.menuList 의 자식 요소 조회
      int menuLevel = menuList.get(i).getMenuLevel() + 1;
      parentMenuId = menuList.get(i).getMenuId();

      List<MenuMasterDto> leafMenu = menuMasterRepository
          .selectAuthMenuListByOption(userMasterDto, menuLevel, parentMenuId, null);

      menuList.get(i).setChildren(leafMenu);

      // 2. 하위 자식이 있을 때 까지 재귀
      if (searchMenuLevel < maxMenuLevel) {
        menuList.get(i).setChildren(
            getUserAuthMenus(userMasterDto, leafMenu, minMenuLevel, maxMenuLevel, menuLevel,
                parentMenuId));
      }

    }

    return menuList;
  }

}
