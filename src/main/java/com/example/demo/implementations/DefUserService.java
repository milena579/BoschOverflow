package com.example.demo.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

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
        List<UserModel> Results = UserRep.findByEdv(data.edv());
        if(Results.isEmpty())
        {
            return null;
        }
        UserModel Usr = Results.get(0);
        if(Usr.password.contentEquals(data.password()))
        {
            return Usr;
        }
        return null;
    }

    @Override
    public String Register(UserData data)
    {
        UserModel Usr = new UserModel();
        Usr.setEdv(data.edv());
        Usr.setName(data.name());
        Usr.setEmail(data.email());
        Usr.setPassword(data.password());
        UserRep.save(Usr);
        return "OK";
    }

    @Override
    public List<UserData> SearchUser(UserQuery query)
    {
        var Results = UserRep.findAll(Pageable.ofSize(query.size()).withPage(query.page()));
        List<UserData> Ret = new ArrayList<>();
        Results.get().forEach((item) -> 
        {
            UserData Data = new UserData
            (
                item.getName(),
                item.getEmail(),
                item.getEdv(),
                item.getPassword()
            );
            Ret.add(Data);
        });
        return Ret;
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