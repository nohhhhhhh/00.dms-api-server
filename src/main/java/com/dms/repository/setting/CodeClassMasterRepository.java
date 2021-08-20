package com.dms.repository.setting;

import static com.dms.entitiy.QCmCodeClassMEntity.cmCodeClassMEntity;

import com.dms.api.dto.setting.CodeMasterDto;
import com.dms.entitiy.CmCodeClassMEntity;
import com.dms.repository.DmsBaseRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CodeClassMasterRepository extends DmsBaseRepository<CmCodeClassMEntity, Long> {

  @Autowired
  private JPAQueryFactory queryFactory;


  /**
   * 공통 코드 클래스 정보 리스트 조회 .
   *
   * @author NOH
   * @since 1.0
   */
  public List<CmCodeClassMEntity> selectCodeClassMasterList(CodeMasterDto codeMasterDto) {

    return queryFactory
        .select(cmCodeClassMEntity).from(cmCodeClassMEntity)
        .where(
            eq(cmCodeClassMEntity.useYn, codeMasterDto.getUseYn()),
            eq(cmCodeClassMEntity.plantId, codeMasterDto.getPlantId()),
            lkIdOrName(cmCodeClassMEntity.codeClsId, cmCodeClassMEntity.codeClsNm,
                codeMasterDto.getIdOrName())
        )
        .orderBy(cmCodeClassMEntity.seq.asc())
        .fetch();

  }

}
