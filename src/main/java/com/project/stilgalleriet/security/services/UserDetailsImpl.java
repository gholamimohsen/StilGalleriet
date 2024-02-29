package com.project.stilgalleriet.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


public class UserDetailsImpl implements UserDetails { //UserDetails Interface är grundläggande uppgifter som krävs för att autentisera en användare.
    private static final long serialVersionUID = 1L; //En standardpraxis när man implementerar Serializable gränssnittet.

    private String id;
    private String username;
    private String firsName;
    private String lastName;
    private String email;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;


    public UserDetailsImpl(String id, String username, String firsName, String lastName, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.firsName = firsName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }
/*
    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()//1. implementera @DBRef private Set<Role> roles = new HashSet<>(); på User model. 2. Skapa getters och setters för instansvariabeln Role.
                .map(role-> new SimpleGrantedAuthority(role.getRolePermission().rolePermission()))
                .collect(Collectors.toList());

        return  new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                authorities); */

    }










}
