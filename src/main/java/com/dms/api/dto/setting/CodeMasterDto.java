package com.dms.api.dto.setting;

import com.dms.api.dto.common.CommonDto;
import java.util.ArrayList;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class CodeMasterDto extends CommonDto {

  @NonNull
  private String codeClsId;
  private String codeClsNm;
  private String codeClsType;
  private String codeId;
  private String codeVal;
  private String codeNm;
  private String parentCodeClsId;
  private String parentCodeId;
  private String defaultYn;
  private Boolean allYn;
  private ArrayList<String> arrCodeClsId;

}
