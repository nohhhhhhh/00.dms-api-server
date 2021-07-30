package com.dms.api.service.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.setting.MenuMasterDto;
import com.dms.api.dto.setting.UserMasterDto;
import com.dms.api.repository.setting.MenuMasterRepository;
import java.time.LocalDateTime;
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

  public ResponseEntity<Response> getTopItems(UserMasterDto userMasterDto) throws Exception {

    try {
      status = 200;
      message = "HttpStatus.OK";
      resultData = new HashMap<String, Object>();

      HashMap<String, Object> minMaxMap = menuMasterRepository.selectMinMaxLevel(userMasterDto);

      var minMenuLevel = Integer.parseInt(minMaxMap.get("minMenuLevel").toString());
      var maxMenuLevel = Integer.parseInt(minMaxMap.get("maxMenuLevel").toString());
      var parentMenuId = "";

      List<HashMap<String, Object>> menuTreeList = new ArrayList<>();
      List<MenuMasterDto> menuList = new ArrayList<>();

      menuList = getUserAuthMenus(userMasterDto, menuList, minMenuLevel, maxMenuLevel, minMenuLevel,
          parentMenuId);

      resultData.put("userAuthMenuList", menuList);

    } catch (Exception e) {
      message = e.getMessage();
    }

    Response response = new Response(status, LocalDateTime.now(), message, resultData);

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
          .selectAuthMenuListByOption(userMasterDto, searchMenuLevel, parentMenuId);
    }

    for (int i = 0; i < menuList.size(); i++) {
      // 1.menuList 의 자식 요소 조회// 1.menuList 의 자식 요소 조회
      int menuLevel = menuList.get(i).getMenuLevel() + 1;
      parentMenuId = menuList.get(i).getMenuId();

      List<MenuMasterDto> leafMenu = menuMasterRepository
          .selectAuthMenuListByOption(userMasterDto, menuLevel, parentMenuId);

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
