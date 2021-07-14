package com.dms.api.repository.common.user;

import static com.dms.api.entitiy.common.user.QUserMaster.userMaster;

import com.dms.api.dto.common.user.UserBaseDto;
import com.dms.api.entitiy.common.user.UserMaster;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserMasterRepo {

  @Autowired
  private JPAQueryFactory queryFactory;

  public List<UserMaster> findByOption(UserBaseDto userMasterDto) {
    return queryFactory.selectFrom(userMaster)
        .where(userMaster.useYn.eq(userMasterDto.getUseYn()))
        .orderBy(userMaster.createDt.desc()).fetch();
  }

  private OrderSpecifier<?> getSortedColumn(Order order, String orderField) {
    Path<Object> fieldPath = Expressions.path(Object.class, userMaster, orderField);
    return new OrderSpecifier(order, fieldPath);
  }

}
