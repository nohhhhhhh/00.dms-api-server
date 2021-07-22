package com.dms.api.repository.setting;

import com.dms.api.entitiy.setting.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("LagacyUserMasterRepository")
public interface LagacyUserMasterRepository extends JpaRepository<UserMaster, Long> {

}
