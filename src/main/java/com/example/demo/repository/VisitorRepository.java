package com.example.demo.repository;

import com.example.demo.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
    // Custom queries (if needed)
}

