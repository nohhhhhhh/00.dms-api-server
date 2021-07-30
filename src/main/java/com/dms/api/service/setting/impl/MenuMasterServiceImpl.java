package com.dms.api.service.setting.impl;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.setting.MenuMasterDto;
import com.dms.api.dto.setting.UserMasterDto;
import com.dms.api.repository.setting.MenuMasterRepository;
import com.dms.api.service.setting.MenuMasterService;
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

@Service
public class MenuMasterServiceImpl implements MenuMasterService {

  @Autowired
  private MenuMasterRepository menuMasterRepository;

  @Autowired
  private ModelMapper modelMapper;

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
      List<MenuMasterDto> menuList = menuMasterRepository
          .selectAuthMenuListByOption(userMasterDto, minMenuLevel, parentMenuId);

      resultData.put("userAuthMenuList", menuList);

    } catch (Exception e) {
      message = "HttpStatus.INTERNAL_SERVER_ERROR";
    }

    Response response = new Response(status, LocalDateTime.now(), message, resultData);

    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }
}


