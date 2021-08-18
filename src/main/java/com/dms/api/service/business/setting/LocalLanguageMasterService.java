package com.dms.api.service.business.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.setting.LocalLanguageMasterDto;
import com.dms.repository.setting.LocalLanguageMasterRepository;
import java.util.HashMap;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Auth Check Controller.
 *
 * @author NOH
 * @since 1.0
 *
 */
@Service
public class LocalLanguageMasterService {

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private LocalLanguageMasterRepository localLanguageMasterRepository;

  /**
   * Top Menu Item Api of AuthorizedUser.
   *
   * @author NOH
   * @since 1.0
   *
   */
  public ResponseEntity<Response> getLanguageMasters(
      LocalLanguageMasterDto localLanguageMasterDto) {

    HashMap<String, Object> resultData = new HashMap<String, Object>();
    Response response = new Response(resultData);

    resultData.put("dataList", localLanguageMasterRepository
        .selectLocalLanguageList(localLanguageMasterDto));

    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }

}
