package com.dms.api.service.common.user;

import com.dms.api.entitiy.common.user.UserMaster;
import java.util.List;
import java.util.Optional;

public interface UserMasterService {

  public Optional<List<UserMaster>> getUserMasters(UserMaster userMaster);

}
