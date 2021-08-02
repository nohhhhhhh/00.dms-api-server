package com.dms.api.controller.setting;

import com.dms.api.dto.common.Response;
import com.dms.api.dto.setting.UserMasterDto;
import com.dms.api.entitiy.setting.UserMaster;
import com.dms.api.service.setting.UserMasterService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserMaster CRUD Controller.
 *
 * @author NOH
 * @since 1.0
 */
@RestController
@RequestMapping("user-master")
public class UserMasterController {

    @Autowired
    private UserMasterService userMasterService;

    @GetMapping
    @ApiOperation(value = "User List 조회")
    public List<UserMaster> getUserMaster(@ModelAttribute UserMasterDto userMasterDto,
        @RequestParam(required = false) String param) {
        return userMasterService.getUserMaster(userMasterDto);
    }

    @GetMapping("/guide")
    public ResponseEntity<Response> getUserMasters(@ModelAttribute UserMasterDto userMasterDto,
        @RequestParam String param) throws Exception {
        return userMasterService.getUserMasters(userMasterDto);
    }

    @PostMapping
    @ApiOperation(value = "User 등록")
    public ResponseEntity<Response> saveUserMaster(@ModelAttribute UserMasterDto userMasterDto)
        throws Exception {
        return userMasterService.saveUserMaster(userMasterDto);
    }

}
