package com.example.demo.services;

import com.example.demo.model.QuestionModel;

public interface QuestionService {
    QuestionModel createQuestion();
    String deleteQuestion (Long questionId);
    QuestionModel editQuestion(Long questionId);
}
