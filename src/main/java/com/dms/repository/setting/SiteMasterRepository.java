package com.dms.repository.setting;

import static com.dms.entitiy.QCmSiteMEntity.cmSiteMEntity;

import com.dms.api.dto.setting.SiteMasterDto;
import com.dms.entitiy.CmSiteMEntity;
import com.dms.repository.DmsBaseRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class SiteMasterRepository extends DmsBaseRepository<CmSiteMEntity, Long> {

  @Autowired
  private JPAQueryFactory queryFactory;


  /**
   * 사이트 정보 리스트 조회 .
   *
   * @author NOH
   * @since 1.0
   */
  public List<SiteMasterDto> selectSiteList(SiteMasterDto siteMasterDto) {

    return queryFactory
        .select(
            Projections.bean(
                SiteMasterDto.class,
                cmSiteMEntity.siteId,
                cmSiteMEntity.siteNm,
                cmSiteMEntity.seq,
                cmSiteMEntity.createDt,
                cmSiteMEntity.createUserId,
                cmSiteMEntity.updateDt,
                cmSiteMEntity.updateUserId,
                cmSiteMEntity.useYn
            )
        ).from(cmSiteMEntity)
        .where(
            eq(cmSiteMEntity.useYn, siteMasterDto.getUseYn()),
            lkIdOrName(cmSiteMEntity.siteId, cmSiteMEntity.siteNm, siteMasterDto.getIdOrName())
        )
        .orderBy(cmSiteMEntity.seq.asc())
        .fetch();

  }



}
