package com.dms.api.dto.setting;

import com.dms.api.dto.common.CommonDto;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class MenuMasterDto extends CommonDto {

  @NonNull
  private String menuId;
  private String menuNm;
  private String parentMenuId;
  private int menuLevel;
  private int minMenuLevel;
  private int maxMenuLevel;
  private String menuUrl;
  private String linkYn;
  private List<MenuMasterDto> children;

}
