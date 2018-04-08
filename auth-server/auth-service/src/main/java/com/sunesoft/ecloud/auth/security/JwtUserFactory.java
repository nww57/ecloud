package com.sunesoft.ecloud.auth.security;

import com.sunesoft.ecloud.adminclient.dtos.UserLoginDto;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(UserLoginDto user) {

        return new JwtUser(
                user.getUserName(),
                user.getId(),
                user.getAgId(),
                user.getRealName(),
                user.getPassword(),
                null,
                user.getWorkon(),
                user.getLastPasswordResetDate(),
                user.getNeedChangePassword()

        );
    }

}
