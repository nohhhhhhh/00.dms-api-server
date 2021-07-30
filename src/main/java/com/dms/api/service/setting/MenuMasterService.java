package com.dms.api.service.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.setting.UserMasterDto;
import org.springframework.http.ResponseEntity;

public interface MenuMasterService {

  ResponseEntity<Response> getTopItems(UserMasterDto userMasterDto) throws Exception;

}
