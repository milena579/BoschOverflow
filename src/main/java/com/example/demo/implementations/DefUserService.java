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

    }

    @Override
    public Boolean validateEmail(String email)
    {

    }

    @Override
    public Boolean validatePassword(String password)
    {

    }
    
}