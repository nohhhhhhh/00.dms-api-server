package com.dms.repository.setting;

import static com.dms.entitiy.QPmProcessMEntity.pmProcessMEntity;

import com.dms.api.dto.setting.ProcessMasterDto;
import com.dms.entitiy.PmProcessMEntity;
import com.dms.repository.DmsBaseRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ProcessMasterRepository extends DmsBaseRepository<PmProcessMEntity, Long> {

  @Autowired
  private JPAQueryFactory queryFactory;


  /**
   * 공통 코드 클래스 정보 리스트 조회 .
   *
   * @author NOH
   * @since 1.0
   */
  public List<PmProcessMEntity> selectProcessMasterList(
      ProcessMasterDto processMasterDto) {

    return queryFactory
        .select(pmProcessMEntity).from(pmProcessMEntity)
        .where(
            eq(pmProcessMEntity.useYn, processMasterDto.getUseYn()),
            eq(pmProcessMEntity.plantId, processMasterDto.getPlantId()),
            lkIdOrName(pmProcessMEntity.processId, pmProcessMEntity.processNm,
                processMasterDto.getIdOrName())
        )
        .orderBy(pmProcessMEntity.seq.asc())
        .fetch();

  }

}
