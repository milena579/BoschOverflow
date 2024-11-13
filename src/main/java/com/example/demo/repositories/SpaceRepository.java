package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SpaceModel;

@Repository
public interface SpaceRepository extends JpaRepository<SpaceModel, Long>{
    List<SpaceModel> findByName(String name);
}
