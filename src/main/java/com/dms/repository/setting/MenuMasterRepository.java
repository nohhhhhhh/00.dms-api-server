package com.dms.repository.setting;

import static com.dms.entitiy.QCmAccessMEntity.cmAccessMEntity;
import static com.dms.entitiy.QCmAccessMenuREntity.cmAccessMenuREntity;
import static com.dms.entitiy.QCmMenuMEntity.cmMenuMEntity;
import static com.dms.entitiy.QCmUserAccessREntity.cmUserAccessREntity;

import com.dms.api.dto.setting.MenuMasterDto;
import com.dms.api.dto.setting.UserMasterDto;
import com.dms.entitiy.CmMenuMEntity;
import com.dms.repository.DmsBaseRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
@Repository
public class MenuMasterRepository extends DmsBaseRepository<CmMenuMEntity, Long> {

  @Autowired
  private JPAQueryFactory queryFactory;

  public Optional<MenuMasterDto> selectMinMaxLevel(UserMasterDto userMasterDto) {

    return Optional.ofNullable(queryFactory.select(
        Projections.fields(MenuMasterDto.class,
            cmMenuMEntity.menuLevel.max().as("maxMenuLevel"),
            cmMenuMEntity.menuLevel.min().as("minMenuLevel")
        ))
        .from(cmMenuMEntity)
        .where(eqUseYn(userMasterDto.getUseYn()), eqPlantId(userMasterDto.getPlantId()))
        .fetchOne());

  }

  public List<MenuMasterDto> selectAuthMenuListByOption(UserMasterDto userMasterDto,
      int menuLevel, String parentMenuId, String menuId) {

    return queryFactory.select(
        Projections.fields(MenuMasterDto.class,
            cmMenuMEntity.menuId.as("menuId"),
            cmMenuMEntity.menuNm.as("menuNm"),
            cmMenuMEntity.parentMenuId.as("parentMenuId"),
            cmMenuMEntity.menuLevel.as("menuLevel"),
            cmMenuMEntity.menuUrl.as("menuUrl"),
            cmMenuMEntity.seq.as("seq"),
            cmMenuMEntity.linkYn.as("linkYn")
        )
    ).distinct().from(cmMenuMEntity).join(cmAccessMenuREntity)
        .on(cmMenuMEntity.menuId.eq(cmAccessMenuREntity.menuId),
            eqAccessMenuRelationPlantId(userMasterDto.getPlantId()),
            eqAccessMenuRelationUseYn(userMasterDto.getUseYn())
        ).join(cmUserAccessREntity)
        .on(cmUserAccessREntity.accessId.eq(cmAccessMenuREntity.accessId),
            eqUserAcessRelationPlantId(userMasterDto.getPlantId()),
            eqUserAcessRelationUseYn(userMasterDto.getUseYn()),
            eqUserAcessRelationUserId(userMasterDto.getUserId())
        ).join(cmAccessMEntity)
        .on(cmUserAccessREntity.accessId.eq(cmAccessMEntity.accessId),
            eqUserAccessMasterUseYn(userMasterDto.getUseYn()))
        .where(eqUseYn(userMasterDto.getUseYn()), eqMenuLevel(menuLevel),
            eqParentMenuId(parentMenuId), eqMenuId(menuId))
        .fetch();
  }

  private BooleanExpression eqUseYn(String useYn) {
    return StringUtils.isEmpty(useYn) ? null
        : cmMenuMEntity.useYn.eq(useYn);
  }

  private BooleanExpression eqMenuLevel(int menuLevel) {
    return StringUtils.isEmpty(menuLevel) ? null
        : cmMenuMEntity.menuLevel.eq(menuLevel);
  }

  private BooleanExpression eqParentMenuId(String parentMenuId) {
    return StringUtils.isEmpty(parentMenuId) ? null
        : cmMenuMEntity.parentMenuId.eq(parentMenuId);
  }

  private BooleanExpression eqMenuId(String menuId) {
    return StringUtils.isEmpty(menuId) ? null
        : cmMenuMEntity.menuId.eq(menuId);
  }


  private BooleanExpression eqPlantId(String plantId) {
    return StringUtils.isEmpty(plantId) ? null
        : cmMenuMEntity.plantId.eq(plantId);
  }

  private BooleanExpression eqAccessMenuRelationPlantId(String plantId) {
    return StringUtils.isEmpty(plantId) ? null
        : cmAccessMenuREntity.plantId.eq(plantId);
  }

  private BooleanExpression eqAccessMenuRelationUseYn(String useYn) {
    return StringUtils.isEmpty(useYn) ? null
        : cmAccessMenuREntity.useYn.eq(useYn);
  }

  private BooleanExpression eqUserAcessRelationPlantId(String plantId) {
    return StringUtils.isEmpty(plantId) ? null
        : cmUserAccessREntity.plantId.eq(plantId);
  }

  private BooleanExpression eqUserAcessRelationUseYn(String useYn) {
    return StringUtils.isEmpty(useYn) ? null
        : cmUserAccessREntity.useYn.eq(useYn);
  }

  private BooleanExpression eqUserAcessRelationUserId(String userId) {
    return StringUtils.isEmpty(userId) ? null
        : cmUserAccessREntity.userId.eq(userId);
  }

  private BooleanExpression eqUserAccessMasterUseYn(String useYn) {
    return StringUtils.isEmpty(useYn) ? null
        : cmAccessMEntity.useYn.eq(useYn);
  }

}
