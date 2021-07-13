package com.dms.api.repository.common.user;

import com.dms.api.entitiy.common.user.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userMasterRepository")
public interface UserMasterRepository extends JpaRepository<UserMaster, Long> {

}
