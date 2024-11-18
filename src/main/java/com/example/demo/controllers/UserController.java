package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.*;
import com.example.demo.implementations.PassEncoder;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.*;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService service;

    @Autowired
    UserRepository repo;

    @Autowired
    PassEncoder encoder;

    @Autowired
    JWTService<Token> jwtService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody UserData data) {
        if(!service.validateEmail(data.email()))
        {
            return new ResponseEntity<>("Email inválido", HttpStatus.BAD_REQUEST);
        }
        if (!service.validateName(data.name()))
        {
            return new ResponseEntity<>("Nome inválido", HttpStatus.BAD_REQUEST);
        }
        if(!service.validatePassword(data.password()))
        {
            return new ResponseEntity<>("Senha deve ter no minímo 12 caracteres, letra maiuscula, letra minuscula e número", HttpStatus.BAD_REQUEST);
        }

        service.Register(data);
        return new ResponseEntity<>("Usuário cadastrado", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserData>> getUser(int page, int size, String name) {
        UserQuery queryUser = new UserQuery(name, page, size);

        return new ResponseEntity<>(service.SearchUser(queryUser), HttpStatus.OK);
    }

    @PostMapping 
    public ResponseEntity<String> login(@RequestBody UserLoginData user) {

        if (user.edv() == null && user.password() == null) {
            return new ResponseEntity<>("edv and password are expected", HttpStatus.BAD_REQUEST);
        }
        var users = repo.findByEdv(user.edv());

        if (users.isEmpty()) {
            return new ResponseEntity<>("The user not exists", HttpStatus.UNAUTHORIZED);
        }

        var currentUser = users.get(0);

        if(!encoder.matches(user.password(), currentUser.getPassword())) {
            return new ResponseEntity<>("The password is incorret", HttpStatus.UNAUTHORIZED);
        }

        Token token = new Token(currentUser.getId());

        var jwt = jwtService.get(token);

        return new ResponseEntity<>(jwt, HttpStatus.OK);
    }
}