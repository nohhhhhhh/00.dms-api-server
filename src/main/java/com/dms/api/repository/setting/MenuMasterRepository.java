package com.dms.api.repository.setting;

import static com.dms.api.entitiy.setting.QAccessMaster.accessMaster;
import static com.dms.api.entitiy.setting.QAccessMenuRelation.accessMenuRelation;
import static com.dms.api.entitiy.setting.QMenuMaster.menuMaster;
import static com.dms.api.entitiy.setting.QUserAcessRelation.userAcessRelation;

import com.dms.api.dto.setting.MenuMasterDto;
import com.dms.api.dto.setting.UserMasterDto;
import com.dms.api.entitiy.setting.UserMaster;
import com.dms.api.repository.DmsBaseRepository;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.HashMap;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
@Repository
public class MenuMasterRepository extends DmsBaseRepository<UserMaster, Long> {

  @Autowired
  private JPAQueryFactory queryFactory;

  public HashMap<String, Object> selectMinMaxLevel(UserMasterDto userMasterDto) {

    HashMap<String, Object> resultMap = new HashMap<>();
    Tuple minMaxLevel = queryFactory.select(
        menuMaster.menuLevel.max().as("maxMenuLevel"),
        menuMaster.menuLevel.min().as("minMenuLevel"))
        .from(menuMaster)
        .where(eqUseYn(userMasterDto.getUseYn()), eqPlantId(userMasterDto.getPlantId())).fetchOne();

    resultMap.put("maxMenuLevel", minMaxLevel.get(0, Float.class));
    resultMap.put("minMenuLevel", minMaxLevel.get(1, Float.class));

    return resultMap;
  }

  public List<MenuMasterDto> selectAuthMenuListByOption(UserMasterDto userMasterDto,
      int menuLevel, String parentMenuId, String menuId) {

    return queryFactory.select(
        Projections.fields(MenuMasterDto.class,
            menuMaster.menuId.as("menuId"),
            menuMaster.menuNm.as("menuNm"),
            menuMaster.parentMenuId.as("parentMenuId"),
            menuMaster.menuLevel.as("menuLevel"),
            menuMaster.menuUrl.as("menuUrl"),
            menuMaster.seq.as("seq"),
            menuMaster.linkYn.as("linkYn")
        )
    ).distinct().from(menuMaster).join(accessMenuRelation)
        .on(menuMaster.menuId.eq(accessMenuRelation.menuId),
            eqAccessMenuRelationPlantId(userMasterDto.getPlantId()),
            eqAccessMenuRelationUseYn(userMasterDto.getUseYn())
        ).join(userAcessRelation)
        .on(userAcessRelation.accessId.eq(accessMenuRelation.accessId),
            eqUserAcessRelationPlantId(userMasterDto.getPlantId()),
            eqUserAcessRelationUseYn(userMasterDto.getUseYn()),
            eqUserAcessRelationUserId(userMasterDto.getUserId())
        ).join(accessMaster)
        .on(userAcessRelation.accessId.eq(accessMaster.accessId),
            eqUserAccessMasterUseYn(userMasterDto.getUseYn()))
        .where(eqUseYn(userMasterDto.getUseYn()), eqMenuLevel(menuLevel),
            eqParentMenuId(parentMenuId), eqMenuId(menuId))
        .fetch();
  }

  private BooleanExpression eqUseYn(String useYn) {
    return StringUtils.isEmpty(useYn) ? null
        : menuMaster.useYn.eq(useYn);
  }

  private BooleanExpression eqMenuLevel(int menuLevel) {
    return StringUtils.isEmpty(menuLevel) ? null
        : menuMaster.menuLevel.eq(menuLevel);
  }

  private BooleanExpression eqParentMenuId(String parentMenuId) {
    return StringUtils.isEmpty(parentMenuId) ? null
        : menuMaster.parentMenuId.eq(parentMenuId);
  }

  private BooleanExpression eqMenuId(String menuId) {
    return StringUtils.isEmpty(menuId) ? null
        : menuMaster.menuId.eq(menuId);
  }


  private BooleanExpression eqPlantId(String plantId) {
    return StringUtils.isEmpty(plantId) ? null
        : menuMaster.plantId.eq(plantId);
  }

  private BooleanExpression eqAccessMenuRelationPlantId(String plantId) {
    return StringUtils.isEmpty(plantId) ? null
        : accessMenuRelation.plantId.eq(plantId);
  }

  private BooleanExpression eqAccessMenuRelationUseYn(String useYn) {
    return StringUtils.isEmpty(useYn) ? null
        : accessMenuRelation.useYn.eq(useYn);
  }

  private BooleanExpression eqUserAcessRelationPlantId(String plantId) {
    return StringUtils.isEmpty(plantId) ? null
        : userAcessRelation.plantId.eq(plantId);
  }

  private BooleanExpression eqUserAcessRelationUseYn(String useYn) {
    return StringUtils.isEmpty(useYn) ? null
        : userAcessRelation.useYn.eq(useYn);
  }

  private BooleanExpression eqUserAcessRelationUserId(String userId) {
    return StringUtils.isEmpty(userId) ? null
        : userAcessRelation.userId.eq(userId);
  }

  private BooleanExpression eqUserAccessMasterUseYn(String useYn) {
    return StringUtils.isEmpty(useYn) ? null
        : accessMaster.useYn.eq(useYn);
  }

}
