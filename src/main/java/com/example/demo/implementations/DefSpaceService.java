package com.example.demo.implementations;

import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import com.example.demo.dto.SpaceQuery;
import com.example.demo.model.SpaceModel;
import com.example.demo.repositories.SpaceRepository;
import com.example.demo.services.SpaceService;

public class DefSpaceService implements SpaceService {
    @Autowired
    SpaceRepository spaceRep;

    @Override
    public String createSpace(String name) {
        SpaceModel space = new SpaceModel();
        space.setName(name);
        spaceRep.save(space);
        return "Espaço cadastrado!";
    }

    @Override
    public List<SpaceModel> searchSpace(SpaceQuery query) {
        var Results = spaceRep.findAll(Pageable.ofSize(query.size()).withPage(query.page())).getContent();
        List<SpaceModel> Ret = new ArrayList<>();
        
        if (Results == null) {
            return Ret;
        } else {
            return Results;
        }
    }

    @Override
    public String givePermission(Long userId, Long spaceId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
