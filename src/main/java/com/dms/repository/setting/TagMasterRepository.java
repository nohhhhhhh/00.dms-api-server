package com.dms.repository.setting;

import static com.dms.entitiy.QEmTagMEntity.emTagMEntity;

import com.dms.api.dto.setting.TagMasterDto;
import com.dms.entitiy.EmTagMEntity;
import com.dms.repository.DmsBaseRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class TagMasterRepository extends DmsBaseRepository<EmTagMEntity, Long> {

  @Autowired
  private JPAQueryFactory queryFactory;


  /**
   * 사이트 정보 리스트 조회 .
   *
   * @author NOH
   * @since 1.0
   */
  public List<EmTagMEntity> selectTagList(TagMasterDto tagMasterDto) {

    return queryFactory
        .select(emTagMEntity).from(emTagMEntity)
        .where(
            eq(emTagMEntity.useYn, tagMasterDto.getUseYn()),
            lkIdOrName(emTagMEntity.tagId, emTagMEntity.tagNm, tagMasterDto.getIdOrName())
        )
        .orderBy(emTagMEntity.seq.asc())
        .fetch();

  }



}
