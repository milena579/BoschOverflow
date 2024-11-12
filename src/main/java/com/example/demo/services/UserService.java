package com.example.demo.services;

import java.util.List;

import com.example.demo.model.UserModel;

public interface UserService {
    public List<UserModel> findAllUsers();
    public String Login();
    public String Register();
}
