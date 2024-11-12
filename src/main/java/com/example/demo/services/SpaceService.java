package com.example.demo.services;

import java.util.List;

import com.example.demo.model.SpaceModel;

public interface SpaceService {
    public String createSpace();
    public String deleteSpace();
    public List<SpaceModel> findAllSpaces();
    
}
