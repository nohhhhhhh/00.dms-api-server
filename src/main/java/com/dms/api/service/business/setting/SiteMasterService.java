package com.dms.api.service.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.SiteMasterDto;
import com.dms.entitiy.CmSiteMEntity;
import com.dms.repository.setting.SiteMasterRepository;
import java.util.HashMap;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SiteMasterService {

  @Autowired
  private SiteMasterRepository siteMasterRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private PasswordEncoder passwordEncoder;


  public ResponseEntity<Response> getSiteMasters(SiteMasterDto siteMasterDto) {

    Map<String, Object> resultData = new HashMap<String, Object>();
    resultData.put("dataList", siteMasterRepository.selectSiteList(siteMasterDto));
    Response response = new Response(resultData);

    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

  public ResponseEntity<Response> saveSiteMaster(SiteMasterDto siteMasterDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();

    siteMasterDto.setCreateUserId(authorizedUser.getUserId());
    CmSiteMEntity siteMEntity = modelMapper.map(siteMasterDto, CmSiteMEntity.class);
    siteMasterRepository.merge(siteMEntity);

    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

  public ResponseEntity<Response> updateSiteMaster(SiteMasterDto siteMasterDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();

    siteMasterDto.setUpdateUserId(authorizedUser.getUserId());
    CmSiteMEntity siteMEntity = modelMapper.map(siteMasterDto, CmSiteMEntity.class);
    siteMasterRepository.merge(siteMEntity);

    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

  public ResponseEntity<Response> deleteSiteMaster(SiteMasterDto siteMasterDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();

    siteMasterDto.setUpdateUserId(authorizedUser.getUserId());
    siteMasterDto.setUseYn("N");
    CmSiteMEntity siteMEntity = modelMapper.map(siteMasterDto, CmSiteMEntity.class);
    siteMasterRepository.merge(siteMEntity);

    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

}
