package com.dms.repository.setting;

import static com.dms.entitiy.QCmLocalLanguageMEntity.cmLocalLanguageMEntity;

import com.dms.api.dto.setting.LocalLanguageMasterDto;
import com.dms.entitiy.CmLocalLanguageMEntity;
import com.dms.repository.DmsBaseRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class LocalLanguageMasterRepository extends DmsBaseRepository<CmLocalLanguageMEntity, Long> {

  @Autowired
  private JPAQueryFactory queryFactory;

  public List<LocalLanguageMasterDto> selectLocalLanguageList(
      LocalLanguageMasterDto userMasterDto) {

    return queryFactory.select(
        Projections.fields(LocalLanguageMasterDto.class,
            cmLocalLanguageMEntity.language.as("language"),
            cmLocalLanguageMEntity.languageKey.as("languageKey"),
            cmLocalLanguageMEntity.message.as("message"),
            cmLocalLanguageMEntity.messageType.as("messageType")
        ))
        .from(cmLocalLanguageMEntity)
        .fetch();

  }

}
