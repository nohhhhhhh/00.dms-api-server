package com.dms.utils.queryDsl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringPath;
import java.util.ArrayList;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CommonBooleanExpression {

  /**
   * Compare Column to parameter (String).
   *
   * @author NOH
   * @since 1.0
   *
   */
  public BooleanExpression eq(StringPath entityStringPath, String compareParam) {
    return !StringUtils.hasText(compareParam) ? null
        : entityStringPath.eq(compareParam);

  }

  /**
   * Compare Column to parameter.
   *
   * @author NOH
   * @since 1.0
   *
   */
  public BooleanExpression lkIdOrName(StringPath entityStringPathId,
    StringPath entityStringPathName, String compareParam) {

    return !StringUtils.hasText(compareParam) ? null
        : entityStringPathId.like("%" + compareParam + "%")
            .or(entityStringPathName.like("%" + compareParam + "%"));

  }

  /**
   * Array In 구문.
   *
   * @author NOH
   * @since 1.0
   *
   */
  public BooleanExpression inArrayList(StringPath entityStringPathId,
      ArrayList<String> arrCodeClsId) {

    return arrCodeClsId == null ? null
        : entityStringPathId.in(arrCodeClsId);

  }


}
