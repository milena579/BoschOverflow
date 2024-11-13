package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.QuestionQuery;
import com.example.demo.model.QuestionModel;

public interface QuestionService {
    QuestionModel createQuestion();
    String deleteQuestion (Long questionId);
    List<QuestionModel> searchQuestion(QuestionQuery query);
    QuestionModel editQuestion(Long questionId);
}
