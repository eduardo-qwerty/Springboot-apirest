package com.jonathaneduardo.app.security;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class AuthCredencial {

    private String email;
    private String password;

}
