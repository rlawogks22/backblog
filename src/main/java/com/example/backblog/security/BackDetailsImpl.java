package com.example.backblog.security;

import com.example.backblog.entitiy.Back;
import com.example.backblog.entitiy.BackRoleEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class BackDetailsImpl implements UserDetails {

    private final Back back;

    public BackDetailsImpl(Back back) {
        this.back = back;
    }

    public Back getUser() {
        return back;
    }

    @Override
    public String getPassword() {
        return back.getPassword();
    }

    @Override
    public String getUsername() {
        return back.getUsername();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        BackRoleEnum role = back.getRole();
        String authority = role.getAuthority();

        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authority);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(simpleGrantedAuthority);

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}