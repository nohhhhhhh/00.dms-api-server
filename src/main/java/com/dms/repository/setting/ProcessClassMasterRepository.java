package com.dms.repository.setting;

import static com.dms.entitiy.QPmProcessClassMEntity.pmProcessClassMEntity;

import com.dms.api.dto.setting.ProcessMasterDto;
import com.dms.entitiy.PmProcessClassMEntity;
import com.dms.repository.DmsBaseRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ProcessClassMasterRepository extends DmsBaseRepository<PmProcessClassMEntity, Long> {

  @Autowired
  private JPAQueryFactory queryFactory;


  /**
   * 공통 코드 클래스 정보 리스트 조회 .
   *
   * @author NOH
   * @since 1.0
   */
  public List<PmProcessClassMEntity> selectProcessClassMasterList(
      ProcessMasterDto processMasterDto) {

    return queryFactory
        .select(pmProcessClassMEntity).from(pmProcessClassMEntity)
        .where(
            eq(pmProcessClassMEntity.useYn, processMasterDto.getUseYn()),
            eq(pmProcessClassMEntity.plantId, processMasterDto.getPlantId()),
            lkIdOrName(pmProcessClassMEntity.processClsId, pmProcessClassMEntity.processClsNm,
                processMasterDto.getIdOrName())
        )
        .orderBy(pmProcessClassMEntity.seq.asc())
        .fetch();

  }

}
