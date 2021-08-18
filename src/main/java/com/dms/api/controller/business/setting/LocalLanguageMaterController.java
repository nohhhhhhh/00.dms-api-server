package com.dms.api.controller.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.setting.LocalLanguageMasterDto;
import com.dms.api.service.business.setting.LocalLanguageMasterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserMaster CRUD Controller.
 *
 * @author NOH
 * @since 1.0
 */
@RestController
@RequestMapping("language-master")
public class LocalLanguageMaterController {

  @Autowired
  private LocalLanguageMasterService localLanguageMasterService;

  @GetMapping
  @ApiOperation(value = "Local Language List 조회")
  @Cacheable(value = "Name", key = "#root.methodName")
  public ResponseEntity<Response> getLanguageMasters(
      @ModelAttribute LocalLanguageMasterDto localLanguageMasterDto) {
    return localLanguageMasterService.getLanguageMasters(localLanguageMasterDto);
  }

}
