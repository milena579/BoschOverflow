package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.SpaceDTO;
import com.example.demo.dto.SpaceQuery;


public interface SpaceService {
    String createSpace(String name);
    List<SpaceDTO> searchSpace(SpaceQuery query);
    String givePermission(Long userId, Long spaceId, int permission);
}