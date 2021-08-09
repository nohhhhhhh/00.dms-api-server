package com.dms.api.service.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.setting.UserMasterDto;
import com.dms.entitiy.CmUserMEntity;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface UserMasterService {

  List<CmUserMEntity> getUserMaster(UserMasterDto userMasterDto);

  ResponseEntity<Response> getUserMasters(UserMasterDto userMasterDto) throws Exception;

  ResponseEntity<Response> saveUserMaster(UserMasterDto userMasterDto) throws Exception;

  ResponseEntity<Response> updateUserMaster(UserMasterDto userMasterDto);

  ResponseEntity<Response> deleteUserMaster(UserMasterDto userMasterDto);

}
