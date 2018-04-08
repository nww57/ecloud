package com.sunesoft.ecloud.auth.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;
/**
 * Created by stephan on 20.03.16.
 */
public class JwtUser implements UserDetails {

    private final UUID id;
    private final UUID agencyid;
    private final String username;
    private final String password;
    private final String realname;
    private final Collection<? extends GrantedAuthority> authorities;
    private final Boolean enabled;
    private final Date lastPasswordResetDate;
    private final Boolean needChangePassword;

    public JwtUser(
            String username,
            UUID id,
            UUID agencyid,
            String realname,
            String password,
            Collection<? extends GrantedAuthority> roles,
            Boolean enabled,
            Date lastPasswordResetDate,
            Boolean needChangePassword
    ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.authorities = roles;
        this.enabled = enabled;
        this.agencyid = agencyid;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.needChangePassword = needChangePassword;
    }


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

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }
    @JsonIgnore
    public Boolean getNeedChangePassword() {
        return needChangePassword;
    }

    public String getRealname() {
        return realname;
    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }



    @JsonIgnore
    public boolean isEnabled() {
        return enabled==null?true:enabled;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}
