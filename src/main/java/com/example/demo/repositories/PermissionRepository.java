package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.PermissionModel;

public interface PermissionRepository extends JpaRepository<PermissionModel, Long> {
    List<PermissionModel> findByPermission(int permission);

    @Query("SELECT COUNT(p) FROM Permission p WHERE s.user IS NOT NULL")
    Integer countUserInPermission();
}
