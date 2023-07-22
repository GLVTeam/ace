package com.github.gabrielrechbrand.ace.controller;

import com.github.gabrielrechbrand.ace.model.AbstractEntity;
import com.github.gabrielrechbrand.ace.service.AbstractService;
import jakarta.persistence.MappedSuperclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@MappedSuperclass
public abstract class AbstractController<T extends AbstractEntity, S extends AbstractService> {

    @Autowired
    private S service;

    @GetMapping
    public ResponseEntity<List<T>> findAll() {
        List<T> entities = service.findAll();
        return ResponseEntity.ok(entities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable UUID id) {
        T entity = (T) service.findById(id);
        if (entity != null) {
            return ResponseEntity.ok(entity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T entity) {
        T savedEntity = (T) service.create(entity);
        return ResponseEntity.ok(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable UUID id, @RequestBody T entity) {
        T existingEntity = (T) service.findById(id);
        if (existingEntity != null) {
            entity.setId(id);
            T updatedEntity = (T) service.update(entity);
            return ResponseEntity.ok(updatedEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        T existingEntity = (T) service.findById(id);
        if (existingEntity != null) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
