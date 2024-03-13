package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.VisitorService;


@RestController
@RequestMapping("/api/min-max")
public class MinMaxController {
	private final VisitorService visitorService;

    @Autowired
    public MinMaxController (VisitorService visitorService) {
        this.visitorService = visitorService;
    }
	
    @GetMapping("/minimal-total")
    public ResponseEntity<Double> getMinimalTotal() {
        double minimalTotal = visitorService.calculateMinimalTotal();
        return ResponseEntity.ok(minimalTotal);
    }

    @GetMapping("/maximal-total")
    public ResponseEntity<Double> getMaximalTotal() {
        double maximalTotal = visitorService.calculateMaximalTotal();
        return ResponseEntity.ok(maximalTotal);
    }
    @GetMapping("/total")
    public ResponseEntity<Double> getTotal() {
    	double total = visitorService.calculateTotal();
    	return ResponseEntity.ok(total);
    }
}
