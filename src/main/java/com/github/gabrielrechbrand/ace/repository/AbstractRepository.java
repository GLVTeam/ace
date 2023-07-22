package com.github.gabrielrechbrand.ace.repository;


import com.github.gabrielrechbrand.ace.model.AbstractEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractRepository<T extends AbstractEntity, K>  extends CrudRepository<T, K> {
}
