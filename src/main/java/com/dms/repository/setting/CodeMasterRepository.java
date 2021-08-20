package com.dms.repository.setting;

import static com.dms.entitiy.QCmCodeClassMEntity.cmCodeClassMEntity;
import static com.dms.entitiy.QCmCodeMEntity.cmCodeMEntity;

import com.dms.api.dto.setting.CodeMasterDto;
import com.dms.entitiy.CmCodeMEntity;
import com.dms.repository.DmsBaseRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CodeMasterRepository extends DmsBaseRepository<CmCodeMEntity, Long> {

  @Autowired
  private JPAQueryFactory queryFactory;


  /**
   * 공통 코드 정보 리스트 조회 .
   *
   * @author NOH
   * @since 1.0
   */
  public List<CmCodeMEntity> selectCodeMasterList(CodeMasterDto codeMasterDto) {

    return queryFactory
        .select(cmCodeMEntity).from(cmCodeMEntity)
        .join(cmCodeClassMEntity)
        .on(cmCodeMEntity.codeClsId.eq(cmCodeClassMEntity.codeClsId),
            cmCodeMEntity.plantId.eq(cmCodeClassMEntity.plantId),
            cmCodeMEntity.useYn.eq(cmCodeClassMEntity.useYn)
        )
        .where(
            eq(cmCodeMEntity.useYn, codeMasterDto.getUseYn()),
            eq(cmCodeMEntity.plantId, codeMasterDto.getPlantId()),
            inArrayList(cmCodeMEntity.codeClsId, codeMasterDto.getArrCodeClsId()),
            lkIdOrName(cmCodeMEntity.codeId, cmCodeMEntity.codeId, codeMasterDto.getIdOrName())
        )
        .orderBy(cmCodeMEntity.seq.asc())
        .fetch();

  }

}
