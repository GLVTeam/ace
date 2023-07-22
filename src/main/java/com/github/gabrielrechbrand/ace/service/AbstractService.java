package com.github.gabrielrechbrand.ace.service;

import com.github.gabrielrechbrand.ace.model.AbstractEntity;
import com.github.gabrielrechbrand.ace.repository.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public abstract class AbstractService<T extends AbstractEntity, R extends AbstractRepository<T, UUID>> {

    @Autowired
    protected R repository;

    public T create(T entity) {
        return repository.save(entity);
    }

    public T update(T entity) {
        return repository.save(entity);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public List<T> findAll() {
        return (List<T>) repository.findAll();
    }

    public T findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

}
