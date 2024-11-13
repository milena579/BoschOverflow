package com.example.demo.services;

import com.example.demo.model.AnswerModel;

public interface AnswerService {
    AnswerModel createAnswer();
    String deleteAnswer(Long answerId);
    AnswerModel editAnswer(Long answerId);
}
