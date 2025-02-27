package com.example.demo.repository;

import com.example.demo.model.Visitor;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor, UUID> {
    // Custom queries (if needed)
}

