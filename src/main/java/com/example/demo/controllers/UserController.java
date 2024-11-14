package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.*;
import com.example.demo.repositories.*;
import com.example.demo.services.*;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService service;

    @Autowired
    UserRepository userRep;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody UserData data) {
        if(!service.validateEmail(data.email()))
        {
            return new ResponseEntity<>("Email inválido", HttpStatus.OK);
        }
        if (!service.validateName(data.name()))
        {
            return new ResponseEntity<>("Nome inválido", HttpStatus.OK);
        }
        if(!service.validatePassword(data.password()))
        {
            return new ResponseEntity<>("Senha deve ter no minímo 12 caracteres, letra maiuscula, letra minuscula e número", HttpStatus.OK);
        }
        service.Register(data);
        return new ResponseEntity<>("Usuário cadastrado", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserData>> getUser(int page, int size, String name) {
        UserQuery queryUser = new UserQuery(name, page, size);

        return new ResponseEntity<>(service.SearchUser(queryUser), HttpStatus.OK);
    }
}
