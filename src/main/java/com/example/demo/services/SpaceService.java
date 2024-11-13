package com.example.demo.services;

public interface SpaceService {
    String createSpace();
    String deleteSpace(Long spaceId);
    String givePermission(Long userId, Long spaceId);
}
