package com.sunesoft.ecloud.auth.security;

import com.sunesoft.ecloud.adminclient.dtos.UserLoginDto;

import java.util.Arrays;
import java.util.Date;

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
                true,
            new Date(),
                false

        );
    }

}
