package com.example.demo.dto;

public record UserQuery (
    String name, 
    int page,
    int size
){}
