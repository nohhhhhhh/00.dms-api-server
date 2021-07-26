package com.dms.api.service.common;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.setting.UserMasterDto;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {

  ResponseEntity<Response> generateJsonWebToken(UserMasterDto userMasterDto) throws Exception;

}
