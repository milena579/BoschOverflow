package com.example.demo.controllers

@RestController
@RequestMapping("/user")
public class UserController {
    
    @PostMapping
    public ResponseEntity<String> login(@ResquestBody UserLoginData data) {
        
    }
}
