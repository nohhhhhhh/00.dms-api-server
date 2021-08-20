package com.dms.api.service.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.TagMasterDto;
import com.dms.entitiy.EmTagMEntity;
import com.dms.repository.setting.TagMasterRepository;
import java.util.HashMap;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TagMasterService {

  @Autowired
  private TagMasterRepository tagMasterRepository;

  @Autowired
  private ModelMapper modelMapper;

  public ResponseEntity<Response> getTagMasters(TagMasterDto tagMasterDto) {

    Map<String, Object> resultData = new HashMap<String, Object>();
    resultData.put("dataList", tagMasterRepository.selectTagList(tagMasterDto));
    Response response = new Response(resultData);

    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

  public ResponseEntity<Response> saveTagMaster(TagMasterDto tagMasterDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();

    tagMasterDto.setCreateUserId(authorizedUser.getUserId());
    EmTagMEntity emTagMEntity = modelMapper.map(tagMasterDto, EmTagMEntity.class);
    tagMasterRepository.merge(emTagMEntity);

    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

  public ResponseEntity<Response> updateTagMaster(TagMasterDto tagMasterDto,
      AuthorizedUser authorizedUser) {

    Map<String, Object> resultData = new HashMap<String, Object>();

    tagMasterDto.setUpdateUserId(authorizedUser.getUserId());
    EmTagMEntity emTagMEntity = modelMapper.map(tagMasterDto, EmTagMEntity.class);
    tagMasterRepository.merge(emTagMEntity);


    Response response = new Response(resultData);
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

}
