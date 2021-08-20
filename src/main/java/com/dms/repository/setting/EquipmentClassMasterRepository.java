package com.dms.repository.setting;

import static com.dms.entitiy.QEmEquipmentClassMEntity.emEquipmentClassMEntity;

import com.dms.api.dto.setting.EquipmentMasterDto;
import com.dms.entitiy.EmEquipmentClassMEntity;
import com.dms.repository.DmsBaseRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class EquipmentClassMasterRepository extends
    DmsBaseRepository<EmEquipmentClassMEntity, Long> {

  @Autowired
  private JPAQueryFactory queryFactory;


  /**
   * 공통 코드 클래스 정보 리스트 조회 .
   *
   * @author NOH
   * @since 1.0
   */
  public List<EmEquipmentClassMEntity> selectEquipmentClassMasterList(
      EquipmentMasterDto equipmentMasterDto) {

    return queryFactory
        .select(emEquipmentClassMEntity).from(emEquipmentClassMEntity)
        .where(
            eq(emEquipmentClassMEntity.useYn, equipmentMasterDto.getUseYn()),
            eq(emEquipmentClassMEntity.plantId, equipmentMasterDto.getPlantId()),
            lkIdOrName(emEquipmentClassMEntity.equipmentClassId,
                emEquipmentClassMEntity.equipmentClassNm,
                equipmentMasterDto.getIdOrName())
        )
        .orderBy(emEquipmentClassMEntity.seq.asc())
        .fetch();

  }

}
