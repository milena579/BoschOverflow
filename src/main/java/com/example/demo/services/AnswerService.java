package com.example.demo.services;

import com.example.demo.model.AnswerModel;

public interface AnswerService {
    public AnswerModel createAnswer();
    public String deleteAnswer(Long answerId);
    public AnswerModel editAnswer(Long answerId);
}
