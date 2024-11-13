package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.AnswerModel;

public interface AnswerRepository extends JpaRepository<AnswerModel, Long> {
    
}
