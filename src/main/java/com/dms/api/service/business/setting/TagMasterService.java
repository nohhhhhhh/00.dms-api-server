package com.dms.api.service.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.TagMasterDto;
import com.dms.api.dto.tag.TagDataHistoryDto;
import com.dms.core.poi.DmsPoiUtils;
import com.dms.entitiy.EmTagMEntity;
import com.dms.repository.setting.TagMasterRepository;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
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

  public ResponseEntity<InputStreamResource> exportTagData(TagDataHistoryDto tagDataHistoryDto)
      throws IOException {

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Disposition", "attachment; filename=customers.xlsx");


    Map<String, Object> resultData = new HashMap<String, Object>();
    List<TagDataHistoryDto> test = tagMasterRepository.selectTagDataList(tagDataHistoryDto);
    System.out.println(test.size()+"::::::::::::::::::::::::::::");

    ByteArrayInputStream in = DmsPoiUtils.bigDataExport(test);

    resultData.put("dataList", test);
    Response response = new Response(resultData);


    return ResponseEntity.ok()
        .headers(headers).body(new InputStreamResource(in));

  }
}
