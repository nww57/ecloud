package com.sunesoft.ecloud.auth.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/24
 */
public class JwtUser {

    private final UUID id;
    private final UUID agencyid;
    private final String username;
    private final String realname;
    private final List<String> authorities;
    private final boolean enabled;
    private final Date lastPasswordResetDate;

    public JwtUser(
            String username,
            UUID id,
            UUID agencyid,
            String realname,
            List<String> roles,
            boolean enabled,
            Date lastPasswordResetDate
    ) {
        this.id = id;
        this.username = username;
        this.realname = realname;
        this.authorities = roles;
        this.enabled = enabled;
        this.agencyid = agencyid;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    @JsonIgnore
    public UUID getId() {
        return id;
    }


    public UUID getAgencyid() {
        return agencyid;
    }

    public String getUsername() {
        return username;
    }

    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public String getRealname() {
        return realname;
    }


    public Collection<String> getAuthorities() {
        return authorities;
    }


    public boolean isEnabled() {
        return enabled;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}
