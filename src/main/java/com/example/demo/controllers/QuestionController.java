package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.QuestionData;
import com.example.demo.dto.QuestionQuery;
import com.example.demo.model.*;
import com.example.demo.repositories.QuestionRepository;
import com.example.demo.repositories.SpaceRepository;
import com.example.demo.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController
{
    @Autowired
    QuestionRepository QuestionRep;
    @Autowired
    QuestionService QuestionServ;
    @Autowired
    SpaceRepository SpaceRep;

    @GetMapping("/{space}")
    public ResponseEntity<List<QuestionData>> GetBySpace(@PathVariable String Space, Integer page, Integer size)
    {
        List<SpaceModel> Result = SpaceRep.findByName(Space);
        List<QuestionModel> Questions;
        if(page != null)
        {
            if(size == null)
            {
                Questions = QuestionServ.searchQuestion(new QuestionQuery(Result.get(0).getId(), page, 10));
            }
            Questions = QuestionServ.searchQuestion(new QuestionQuery(Result.get(0).getId(), page, size));
        }else
        {
            Questions = QuestionServ.searchQuestion(new QuestionQuery(Result.get(0).getId(), 0, 0x7fffffff));
        }
        
        List<QuestionData> Return = new ArrayList<>();
        Questions.forEach((item) ->
        {
            Return.add(new QuestionData
            (
                item.getTitle(),
                item.getText(),
                item.getUser().getId(),
                item.getSpace().getId()
            ));
        });

        return new ResponseEntity<>(Return, HttpStatus.OK);
    }
}