package com.dms.api.service.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.setting.UserMasterDto;
import com.dms.api.entitiy.setting.UserMaster;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface UserMasterService {

  List<UserMaster> getUserMaster(UserMasterDto userMasterDto);

  ResponseEntity<Response> getUserMasters(UserMasterDto userMasterDto) throws Exception;

  ResponseEntity<Response> saveUserMaster(UserMasterDto userMasterDto) throws Exception;

}
