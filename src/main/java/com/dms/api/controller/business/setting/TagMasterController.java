package com.dms.api.controller.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.common.auth.AuthorizedUser;
import com.dms.api.dto.setting.TagMasterDto;
import com.dms.api.service.business.setting.TagMasterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tag-master")
public class TagMasterController {

  @Autowired
  private TagMasterService TagMasterService;

  @ApiOperation(value = "Tag 리스트")
  @GetMapping
  public ResponseEntity<Response> getTagMasters(@ModelAttribute TagMasterDto tagMasterDto) {
    return TagMasterService.getTagMasters(tagMasterDto);
  }

  @ApiOperation(value = "Tag 신규 등록")
  @PostMapping
  public ResponseEntity<Response> saveTagMaster(@ModelAttribute TagMasterDto tagMasterDto,
  @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return TagMasterService.saveTagMaster(tagMasterDto, authorizedUser);
  }

  @ApiOperation(value = "Tag 수정")
  @PutMapping
  public ResponseEntity<Response> updateTagMaster(@ModelAttribute TagMasterDto tagMasterDto,
      @AuthenticationPrincipal(expression = "authorizedUser") AuthorizedUser authorizedUser) {
    return TagMasterService.updateTagMaster(tagMasterDto, authorizedUser);
  }

}
