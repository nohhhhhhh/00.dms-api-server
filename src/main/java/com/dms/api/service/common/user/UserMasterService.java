package com.dms.api.service.common.user;

import com.dms.api.dto.common.user.UserBaseDto;
import com.dms.api.entitiy.common.user.UserMaster;
import java.util.List;

public interface UserMasterService {

  public List<UserMaster> getUserMaster(UserBaseDto userMasterDto);

}
