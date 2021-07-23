package com.dms.api.repository.setting;

import static com.dms.api.entitiy.setting.QUserAcessRelation.userAcessRelation;

import com.dms.api.dto.setting.UserMasterDto;
import com.dms.api.entitiy.setting.UserAcessRelation;
import com.dms.api.repository.DmsBaseRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
@Repository
public class UserAcessRelationRepository extends DmsBaseRepository<UserAcessRelation, Long> {

  @Autowired
  private JPAQueryFactory queryFactory;

  public List<UserAcessRelation> selectListByOption(UserMasterDto userMasterDto) {
    return queryFactory.selectFrom(userAcessRelation)
        .where(eqUseYn(userMasterDto.getUseYn()), eqUserId(userMasterDto.getUserId()))
        .orderBy(userAcessRelation.createDt.desc()).fetch();
  }

  private BooleanExpression eqUseYn(String useYn) {
    return StringUtils.isEmpty(useYn) ? null
        : userAcessRelation.useYn.eq(useYn);
  }

  private BooleanExpression eqUserId(String userId) {
    return StringUtils.isEmpty(userId) ? null
        : userAcessRelation.userId.eq(userId);
  }

  private BooleanExpression eqPlantId(String plantId) {
    return StringUtils.isEmpty(plantId) ? null
        : userAcessRelation.plantId.eq(plantId);
  }

}
