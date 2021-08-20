package com.dms.repository.setting;

import static com.dms.entitiy.QEmEquipmentMEntity.emEquipmentMEntity;

import com.dms.api.dto.setting.EquipmentMasterDto;
import com.dms.entitiy.EmEquipmentMEntity;
import com.dms.repository.DmsBaseRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class EquipmentMasterRepository extends
    DmsBaseRepository<EmEquipmentMEntity, Long> {

  @Autowired
  private JPAQueryFactory queryFactory;


  /**
   * 공통 코드 클래스 정보 리스트 조회 .
   *
   * @author NOH
   * @since 1.0
   */
  public List<EmEquipmentMEntity> selectEquipmentMasterList(
      EquipmentMasterDto equipmentMasterDto) {

    return queryFactory
        .select(emEquipmentMEntity).from(emEquipmentMEntity)
        .where(
            eq(emEquipmentMEntity.useYn, equipmentMasterDto.getUseYn()),
            eq(emEquipmentMEntity.plantId, equipmentMasterDto.getPlantId()),
            lkIdOrName(emEquipmentMEntity.equipmentId,
                emEquipmentMEntity.equipmentNm,
                equipmentMasterDto.getIdOrName())
        )
        .orderBy(emEquipmentMEntity.seq.asc())
        .fetch();

  }

}
