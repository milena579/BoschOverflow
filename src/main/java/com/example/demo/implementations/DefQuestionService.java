package com.example.demo.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import com.example.demo.dto.*;
import com.example.demo.model.*;
import com.example.demo.repositories.*;
import com.example.demo.services.QuestionService;

public class DefQuestionService implements QuestionService
{
    @Autowired
    QuestionRepository QuestionRep;
    @Autowired
    SpaceRepository SpaceRep;
    @Autowired
    UserRepository UserRep;

    @Override
    public QuestionModel createQuestion(QuestionData data)
    {
        QuestionModel Question = new QuestionModel();

        Question.setText(data.text());
        Question.setTitle(data.title());

        Optional<SpaceModel> Space = SpaceRep.findById(data.idSpace());
        if(!Space.isPresent()){return null;}
        Question.setSpace(Space.get());

        Optional<UserModel> User = UserRep.findById(data.idUser());
        if(!User.isPresent()){return null;}

        for(PermissionModel permission : User.get().getPermissions())
        {
            if(permission.getSpace().getId() == data.idSpace())
            {
                return QuestionRep.save(Question);
            }
        }
        return null;
    }

    @Override
    public String deleteQuestion(Long questionId)
    {
        QuestionRep.deleteById(questionId);
        return "Deletado";
    }

    @Override
    public List<QuestionModel> searchQuestion(QuestionQuery query)
    {
        return QuestionRep.findAll(Pageable.ofSize(query.size()).withPage(query.page())).getContent();
    }

    @Override
    public QuestionModel editQuestion(Long questionId, QuestionData data)
    {
        var Question = QuestionRep.findById(questionId);
        if(!Question.isPresent())
        {
            return null;
        }
        if(!(Question.get().getUser().getId() == data.idUser()))
        {
            return null;
        }

        if(data.idSpace() != null)
        {
            Optional<SpaceModel> Space = SpaceRep.findById(data.idSpace());
            if(Space.isPresent())
            {
                Question.get().setSpace(Space.get());
            }
        }

        if(data.text() != null)
        {
            Question.get().setText(data.text());
        }

        if(data.title() != null)
        {
            Question.get().setTitle(data.title());
        }

        return QuestionRep.save(Question.get());
    }
}