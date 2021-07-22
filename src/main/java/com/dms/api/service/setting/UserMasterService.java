package com.dms.api.service.setting;

import com.dms.api.dto.ResponseDto;
import com.dms.api.dto.setting.UserMasterDto;
import com.dms.api.entitiy.setting.UserMaster;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface UserMasterService {

  List<UserMaster> getUserMaster(UserMasterDto userMasterDto);

  ResponseEntity<ResponseDto> getUserMasters(UserMasterDto userMasterDto) throws Exception;

  ResponseEntity<ResponseDto> saveUserMaster(UserMasterDto userMasterDto) throws Exception;

}
