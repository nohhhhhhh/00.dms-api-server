package com.dms.repository.setting;

import static com.dms.entitiy.QCmUserMEntity.cmUserMEntity;

import com.dms.api.dto.setting.UserMasterDto;
import com.dms.entitiy.CmUserMEntity;
import com.dms.repository.DmsBaseRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
@Repository
public class UserMasterRepository extends DmsBaseRepository<CmUserMEntity, Long> {

  @Autowired
  private JPAQueryFactory queryFactory;

  /**
   * 유저 정보 단건 조회 .
   *
   * @author NOH
   * @since 1.0
   */
  public Optional<UserMasterDto> selectUserOneByOption(UserMasterDto userMasterDto) {
    return Optional.ofNullable(queryFactory.select(
        Projections.fields(UserMasterDto.class,
            cmUserMEntity.userId.as("userId"),
            cmUserMEntity.userPwd.as("userPwd"),
            cmUserMEntity.userNm.as("userNm"),
            cmUserMEntity.userState.as("userState"),
            cmUserMEntity.useYn.as("useYn")
        )
    ).from(cmUserMEntity)
        .where(eqUseYn(userMasterDto.getUseYn()), lkIdOrName(userMasterDto.getIdOrName()),
            eqUserId(userMasterDto.getUserId()))
        .orderBy(cmUserMEntity.createDt.desc())
        .fetchOne());
  }

  /**
   * 유저 정보 단건 조회 .
   *
   * @author NOH
   * @since 1.0
   */
  public List<CmUserMEntity> selectUserListByOption(UserMasterDto userMasterDto) {
    return queryFactory.selectFrom(cmUserMEntity)
        .where(eqUseYn(userMasterDto.getUseYn()), lkIdOrName(userMasterDto.getIdOrName()),
            eqUserId(userMasterDto.getUserId()))
        .orderBy(cmUserMEntity.createDt.desc()).fetch();
  }

  private BooleanExpression eqUseYn(String useYn) {
    return StringUtils.isEmpty(useYn) ? null
        : cmUserMEntity.useYn.eq(useYn);
  }

  private BooleanExpression eqUserId(String userId) {
    return StringUtils.isEmpty(userId) ? null
        : cmUserMEntity.userId.eq(userId);
  }

  private BooleanExpression lkIdOrName(String idOrName) {
    return StringUtils.isEmpty(idOrName) ? null
        : cmUserMEntity.userId.like("%" + idOrName + "%")
            .or(cmUserMEntity.userNm.like("%" + idOrName + "%"));
  }

}
