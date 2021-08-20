package com.dms.repository.setting;

import static com.dms.entitiy.QCmLineMEntity.cmLineMEntity;

import com.dms.api.dto.setting.LineMasterDto;
import com.dms.entitiy.CmLineMEntity;
import com.dms.repository.DmsBaseRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class LineMasterRepository extends DmsBaseRepository<CmLineMEntity, Long> {

  @Autowired
  private JPAQueryFactory queryFactory;


  /**
   * 라인 정보 리스트 조회 .
   *
   * @author NOH
   * @since 1.0
   */
  public List<CmLineMEntity> selectLineList(LineMasterDto lineMasterDto) {

    return queryFactory
        .select(cmLineMEntity).from(cmLineMEntity)
        .where(
            eq(cmLineMEntity.useYn, lineMasterDto.getUseYn()),
            lkIdOrName(cmLineMEntity.lineId, cmLineMEntity.lineNm, lineMasterDto.getIdOrName()),
            eq(cmLineMEntity.pmsYn, lineMasterDto.getPmsYn()
            )
        )
        .orderBy(cmLineMEntity.seq.asc())
        .fetch();

  }


}
