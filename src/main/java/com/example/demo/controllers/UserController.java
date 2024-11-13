package com.example.demo.controllers;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @PostMapping
    public ResponseEntity<String> create(@ResquestBody UserData data) {

        
    }
}
