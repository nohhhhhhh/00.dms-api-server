package com.dms.repository.setting;

import static com.dms.entitiy.QCmPlantMEntity.cmPlantMEntity;

import com.dms.api.dto.setting.PlantMasterDto;
import com.dms.entitiy.CmPlantMEntity;
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
public class PlantMasterRepository extends DmsBaseRepository<CmPlantMEntity, Long> {

  @Autowired
  private JPAQueryFactory queryFactory;

  public List<CmPlantMEntity> selectListByOption(PlantMasterDto plantMasterDto) {
    return queryFactory.selectFrom(cmPlantMEntity)
        .where(eqUseYn(plantMasterDto.getUseYn()), lkIdOrName(plantMasterDto.getIdOrName()))
        .orderBy(cmPlantMEntity.createDt.desc()).fetch();
  }

  private BooleanExpression eqUseYn(String useYn) {
    return StringUtils.isEmpty(useYn) ? null
        : cmPlantMEntity.useYn.eq(useYn);
  }
  private BooleanExpression lkIdOrName(String idOrName) {
    return StringUtils.isEmpty(idOrName) ? null
        : cmPlantMEntity.plantId.like("%" + idOrName + "%")
            .or(cmPlantMEntity.plantNm.like("%" + idOrName + "%"));
  }

}
