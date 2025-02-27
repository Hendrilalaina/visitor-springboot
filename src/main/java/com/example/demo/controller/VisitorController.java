package com.example.demo.controller;

import com.example.demo.model.Visitor;
import com.example.demo.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {
    private final VisitorRepository visitorRepository;

    @Autowired
    public VisitorController(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @GetMapping
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    @PostMapping
    public Visitor createVisitor(@RequestBody Visitor visitor) {
        return visitorRepository.save(visitor);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Visitor> updateVisitor(@PathVariable UUID id, @RequestBody Visitor updatedVisitor) {
        Optional<Visitor> existingVisitor = visitorRepository.findById(id);

        if (existingVisitor.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Update the properties of the existing visitor
        Visitor visitorToUpdate = existingVisitor.get();
        visitorToUpdate.setName(updatedVisitor.getName());
        visitorToUpdate.setNumberOfDay(updatedVisitor.getNumberOfDay());
        visitorToUpdate.setPrice(updatedVisitor.getPrice());

        // Save the updated visitor
        visitorRepository.save(visitorToUpdate);

        return ResponseEntity.ok(visitorToUpdate);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisitor(@PathVariable UUID id) {
        Optional<Visitor> existingVisitor = visitorRepository.findById(id);

        if (existingVisitor.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Delete the visitor
        visitorRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public Optional<Visitor> getVisitor(@PathVariable UUID id) {
        return visitorRepository.findById(id);
    }
}
