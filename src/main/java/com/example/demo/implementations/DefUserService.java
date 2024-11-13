package com.example.demo.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.*;
import com.example.demo.model.*;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.*;

public class DefUserService implements UserService
{
    @Autowired
    UserRepository UserRep;

    @Override
    public UserModel Login(UserLoginData data)
    {
        UserRep.findByEdv(data.edv());
    }

    @Override
    public String Register(UserData data)
    {

    }

    @Override
    public List<UserData> SearchUser(UserQuery query)
    {
        
    }

    @Override
    public Boolean validateName(String name)
    {
        Boolean forbidden = true;

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) >= 48 && name.charAt(i) <= 57 && name.charAt(i) >= 65 && name.charAt(i) <= 90 && name.charAt(i) >= 97 && name.charAt(i) <= 122 && name.charAt(i) > 127 && name.charAt(i) < 32) {
                forbidden = false;
            }
        }
    
        if (!forbidden) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Boolean validateEmail(String email)
    {
        int at = email.indexOf("@");

        if (at > 0 && at != email.length-1) {
            return true
        } else {
            return false
        }
    }

    @Override
    public Boolean validatePassword(String password)
    {
        boolean minuscula = false;
        boolean maiscula = false;
        boolean numero = false;
        
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 48 && password.charAt(i) <= 57) {
                numero = true;
            }
            
            if (password.charAt(i) >= 65 && password.charAt(i) <= 90) {
                maiscula = true;
            }
            
            if (password.charAt(i) >= 97 && password.charAt(i) <= 122) {
                minuscula = true;
            }
        }

        if (!numero || !maiscula || !minuscula || password.length() < 12) {
            return false;
        } else {
            return true;
        }
    }
    
}