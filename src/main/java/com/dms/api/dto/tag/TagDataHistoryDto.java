package com.dms.api.dto.tag;

import com.dms.api.dto.common.CommonDto;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagDataHistoryDto extends CommonDto {

  private int sourceTbSeq;
  private String tagId;
  private Timestamp eventDt;
  private int val;
  private String defectYn;
  private String defectType;
  private String productId;
  private int usl;
  private int ucl;
  private int cl;
  private int lcl;
  private int lsl;

}
