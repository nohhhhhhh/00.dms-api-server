package com.dms.api.dto.common.auth;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;

/**
 * Spring Security Authorized User Info.
 *
 * @author NOH
 * @since 1.0
 *
 */
public class AuthorizedAdapter extends User {

    private AuthorizedUser authorizedUser;

    public AuthorizedAdapter(AuthorizedUser authorizedUser) {
        /*현재 권한 체계가 없어서 null 로 전달*/
        super(authorizedUser.getUserId(), authorizedUser.getUserPwd(), new ArrayList<>());
        this.authorizedUser = authorizedUser;
    }

    public AuthorizedUser getAuthorizedUser() {
        return authorizedUser;
    }


}
