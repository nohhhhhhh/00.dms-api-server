package com.dms.api.repository.common.user;

import static com.dms.api.entitiy.common.user.QUserMaster.userMaster;

import com.dms.api.dto.common.user.UserMasterDto;
import com.dms.api.entitiy.common.user.UserMaster;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserMasterRepo {

  @Autowired
  private JPAQueryFactory queryFactory;

  public List<UserMaster> findByOption(UserMasterDto userMasterDto) {
    return queryFactory.selectFrom(userMaster)
        .where(userMaster.useYn.eq(userMasterDto.getUseYn()))
        .orderBy(userMaster.createDt.desc()).fetch();
  }

}
