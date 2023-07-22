package com.github.gabrielrechbrand.ace.repository;


import com.github.gabrielrechbrand.ace.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AbstractRepository<T extends AbstractEntity> extends JpaRepository<T, UUID> {
}
