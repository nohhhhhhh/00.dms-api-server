package com.dms.api.repository.setting;

import static com.dms.api.entitiy.setting.QPlantMaster.plantMaster;

import com.dms.api.dto.setting.PlantMasterDto;
import com.dms.api.entitiy.setting.PlantMaster;
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
public class PlantMasterRepository extends DmsBaseRepository<PlantMaster, Long> {

  @Autowired
  private JPAQueryFactory queryFactory;

  public List<PlantMaster> selectListByOption(PlantMasterDto plantMasterDto) {
    return queryFactory.selectFrom(plantMaster)
        .where(eqUseYn(plantMasterDto.getUseYn()), lkIdOrName(plantMasterDto.getIdOrName()))
        .orderBy(plantMaster.createDt.desc()).fetch();
  }

  private BooleanExpression eqUseYn(String useYn) {
    return StringUtils.isEmpty(useYn) ? null
        : plantMaster.useYn.eq(useYn);
  }
  private BooleanExpression lkIdOrName(String idOrName) {
    return StringUtils.isEmpty(idOrName) ? null
        : plantMaster.plantId.like("%" + idOrName + "%")
            .or(plantMaster.plantNm.like("%" + idOrName + "%"));
  }

}
