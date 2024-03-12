package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Visitor;
import com.example.demo.repository.VisitorRepository;

@Service
public class VisitorService {

    private final VisitorRepository visitorRepository;

    @Autowired
    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public double calculateMinimalTotal() {
        List<Visitor> allVisitors = visitorRepository.findAll();
        return allVisitors.stream()
                .mapToDouble(visitor -> visitor.getNumberOfDay() * visitor.getPrice())
                .min()
                .orElse(0.0);
    }

    public double calculateMaximalTotal() {
        List<Visitor> allVisitors = visitorRepository.findAll();
        return allVisitors.stream()
                .mapToDouble(visitor -> visitor.getNumberOfDay() * visitor.getPrice())
                .max()
                .orElse(0.0);
    }
}