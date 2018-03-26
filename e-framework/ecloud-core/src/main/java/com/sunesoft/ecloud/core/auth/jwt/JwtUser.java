package com.sunesoft.ecloud.core.auth.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/24
 */
public class JwtUser{

    private final UUID id;
    private final UUID corpId;
    private final String username;
    private final String firstname;
    private final String lastname;
    private final String password;
    private final String email;
    private final Collection<String> authorities;
    private final boolean enabled;
    private final Date lastPasswordResetDate;

    public JwtUser(
          UUID id,
          String username,
          String firstname,
          String lastname,
          String email,
          String password, Collection<String> authorities,
          boolean enabled,
          UUID corpid,
          Date lastPasswordResetDate
    ) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.enabled = enabled;
        this.corpId= corpid;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    @JsonIgnore
    public UUID getId() {
        return id;
    }
    @JsonIgnore
    public UUID getCorpId() {
        return corpId;
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

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
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
