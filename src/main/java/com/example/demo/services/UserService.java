package com.example.demo.services;

import java.util.List;

import com.example.demo.model.UserModel;

public interface UserService {
    public List<UserModel> findAllUsers();
    public UserModel Login(Long edv, String email,String password);
    public String Register();
    Boolean validaNome(String name);
    Boolean validaEmail(String email);
    Boolean validaSenha(String password);
}
