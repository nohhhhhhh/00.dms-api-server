package com.dms.api.dto.tag;

import com.dms.api.dto.common.CommonDto;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagRawHistoryDto extends CommonDto {

  private int eventsequence;
  private Timestamp eventname;
  private String itemidentity;
  private int itemvalue;
  private String description;
  private String usable;
  private Timestamp transactiontime;

}
