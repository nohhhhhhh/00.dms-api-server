package com.dms.repository.setting;

import static com.dms.entitiy.QPmProcessEquipmentREntity.pmProcessEquipmentREntity;

import com.dms.api.dto.setting.ProcessEquipmentRelationDto;
import com.dms.entitiy.PmProcessEquipmentREntity;
import com.dms.repository.DmsBaseRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ProcessEquipmentRelationRepository extends DmsBaseRepository<PmProcessEquipmentREntity, Long> {

  @Autowired
  private JPAQueryFactory queryFactory;


  /**
   * 공통 코드 클래스 정보 리스트 조회 .
   *
   * @author NOH
   * @since 1.0
   */
  public List<PmProcessEquipmentREntity> selectProcessEquipmentRelationList(
      ProcessEquipmentRelationDto processEquipmentRelationDto) {

    return queryFactory
        .select(pmProcessEquipmentREntity).from(pmProcessEquipmentREntity)
        .where(
            eq(pmProcessEquipmentREntity.useYn, processEquipmentRelationDto.getUseYn()),
            eq(pmProcessEquipmentREntity.plantId, processEquipmentRelationDto.getPlantId()),
            lkIdOrName(pmProcessEquipmentREntity.processId, pmProcessEquipmentREntity.equipmentId,
                processEquipmentRelationDto.getIdOrName())
        )
        .orderBy(pmProcessEquipmentREntity.seq.asc())
        .fetch();

  }

}
