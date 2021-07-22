package com.dms.api.service.setting;

import com.dms.api.dto.ResponseDto;
import com.dms.api.dto.setting.UserMasterDto;
import org.springframework.http.ResponseEntity;

public interface LoginService {

  ResponseEntity<ResponseDto> getUserLoginResult(UserMasterDto userMasterDto) throws Exception;

}
