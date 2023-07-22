package com.github.gabrielrechbrand.ace.service;

import com.github.gabrielrechbrand.ace.model.AbstractEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface AbstractService<T extends AbstractEntity> {

    T create(T entity);

    T update(T entity);

    void delete(UUID id);

    List<T> findAll();

    T findById(UUID id);

}
