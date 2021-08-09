package com.dms.repository.setting;

import static com.dms.entitiy.QCmUserAccessREntity.cmUserAccessREntity;

import com.dms.api.dto.setting.UserMasterDto;
import com.dms.entitiy.CmUserAccessREntity;
import com.dms.repository.DmsBaseRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
@Repository
public class UserAcessRelationRepository extends DmsBaseRepository<CmUserAccessREntity, Long> {

  @Autowired
  private JPAQueryFactory queryFactory;

  public List<CmUserAccessREntity> selectUserAcessListByOption(UserMasterDto userMasterDto) {
    return queryFactory.selectFrom(cmUserAccessREntity)
        .where(eqUseYn(userMasterDto.getUseYn()), eqUserId(userMasterDto.getUserId()),
            eqPlantId(userMasterDto.getPlantId()))
        .orderBy(cmUserAccessREntity.createDt.desc()).fetch();
  }

  private BooleanExpression eqUseYn(String useYn) {
    return StringUtils.isEmpty(useYn) ? null
        : cmUserAccessREntity.useYn.eq(useYn);
  }

  private BooleanExpression eqUserId(String userId) {
    return StringUtils.isEmpty(userId) ? null
        : cmUserAccessREntity.userId.eq(userId);
  }

  private BooleanExpression eqPlantId(String plantId) {
    return StringUtils.isEmpty(plantId) ? null
        : cmUserAccessREntity.plantId.eq(plantId);
  }

}
