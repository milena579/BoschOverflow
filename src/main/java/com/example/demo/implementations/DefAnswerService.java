package com.example.demo.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.*;
import com.example.demo.model.*;
import com.example.demo.repositories.*;
import com.example.demo.services.AnswerService;

public class DefAnswerService implements AnswerService
{
    @Autowired
    AnswerRepository AnswerRep;
    @Autowired
    QuestionRepository QuestionRep;
    @Autowired
    UserRepository UserRep;

    @Override
    public AnswerModel createAnswer(AnswerData data)
    {
        AnswerModel Ans = new AnswerModel();

        Ans.setText(data.text());

        Optional<QuestionModel> Question = QuestionRep.findById(data.idQuestion());
        if(!Question.isPresent()){return null;}
        Ans.setQuestion(Question.get());
        Optional<UserModel> User = UserRep.findById(data.idUser());
        if(!User.isPresent()){return null;}

        for(PermissionModel permission : User.get().getPermissions())
        {
            if(permission.getSpace().getId().compareTo(Question.get().getSpace().getId()) == 0)
            {
                return AnswerRep.save(Ans);
            }
        }
        return null;
    }

    @Override
    public String deleteAnswer(Long answerId)
    {

    }

    @Override
    public AnswerModel editAnswer(Long answerId, AnswerData data)
    {
        
    }
}