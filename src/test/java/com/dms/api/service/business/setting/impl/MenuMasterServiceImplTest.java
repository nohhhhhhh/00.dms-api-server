package com.dms.api.service.business.setting.impl;

import com.dms.repository.setting.MenuMasterRepository;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MenuMasterServiceImplTest {

  @Autowired
  private MenuMasterRepository menuMasterRepository;

  @Autowired
  private ModelMapper modelMapper;

  public int status = 500;
  public String message;
  public Map<String, Object> resultData;
  public List<?> resultList;

  @Test
  public void getTopItems() {



  }
}


