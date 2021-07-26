package com.dms.api.repository.setting;

import static com.dms.api.entitiy.setting.QUserMaster.userMaster;

import com.dms.api.dto.setting.UserMasterDto;
import com.dms.api.entitiy.setting.UserMaster;
import com.dms.api.repository.DmsBaseRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
@Repository
public class UserMasterRepository extends DmsBaseRepository<UserMaster, Long> {

  @Autowired
  private JPAQueryFactory queryFactory;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public List<UserMaster> selectListByOption(UserMasterDto userMasterDto) {
    return queryFactory.selectFrom(userMaster)
        .where(eqUseYn(userMasterDto.getUseYn()), lkIdOrName(userMasterDto.getIdOrName()),
            eqUserId(userMasterDto.getUserId()), eqUserPwd(userMasterDto.getUserPwd()))
        .orderBy(userMaster.createDt.desc()).fetch();
  }

  private BooleanExpression eqUseYn(String useYn) {
    return StringUtils.isEmpty(useYn) ? null
        : userMaster.useYn.eq(useYn);
  }

  private BooleanExpression eqUserId(String userId) {
    return StringUtils.isEmpty(userId) ? null
        : userMaster.userId.eq(userId);
  }

  private BooleanExpression eqUserPwd(String userPwd) {
    return StringUtils.isEmpty(userPwd) ? null
        : userMaster.userPwd.eq(userPwd);
  }

  private BooleanExpression lkIdOrName(String idOrName) {
    return StringUtils.isEmpty(idOrName) ? null
        : userMaster.userId.like("%" + idOrName + "%")
            .or(userMaster.userNm.like("%" + idOrName + "%"));
  }

}
