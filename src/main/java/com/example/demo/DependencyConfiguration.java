package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.implementations.DefUserService;
import com.example.demo.services.*;

@Configuration
public class DependencyConfiguration
{
    @Bean
    @Scope("singleton")
    public UserService userService()
    {
        return new DefUserService();
    }

    @Bean
    @Scope("singleton")
    public QuestionService questionService()
    {
        return null;
    }

    @Bean
    @Scope("singleton")
    public SpaceService spaceService()
    {
        return null;
    }

    @Bean
    @Scope("singleton")
    public AnswerService answerService()
    {
        return null;
    }
}