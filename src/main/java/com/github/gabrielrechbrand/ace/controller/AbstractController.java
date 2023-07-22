package com.github.gabrielrechbrand.ace.controller;

import com.github.gabrielrechbrand.ace.model.AbstractEntity;
import com.github.gabrielrechbrand.ace.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public abstract class AbstractController<T extends AbstractEntity> {

    @Autowired
    private AbstractService<T> service;


    @GetMapping
    public ResponseEntity<List<T>> findAll() {
        List<T> entities = service.findAll();
        return ResponseEntity.ok(entities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable UUID id) {
        T entity = service.findById(id);
        if (entity != null) {
            return ResponseEntity.ok(entity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T entity) {
        T savedEntity = service.create(entity);
        return ResponseEntity.ok(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable UUID id, @RequestBody T entity) {
        T existingEntity = service.findById(id);
        if (existingEntity != null) {
            entity.setId(id);
            T updatedEntity = service.update(entity);
            return ResponseEntity.ok(updatedEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        T existingEntity = service.findById(id);
        if (existingEntity != null) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
