package com.argusoft.appointment.utils.security.config;


import com.argusoft.appointment.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {



    private int id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    public MyUserDetails(int id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }


//    @Transactional
    public static MyUserDetails build(User user){
//        Set<Role> authorities2 = user.getRoles();

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add( new SimpleGrantedAuthority(user.getRole().getRoleName()));
        return new MyUserDetails(user.getUserId(),user.getContactNo(), user.getPassword(), authorities);
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;
    }



    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
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
