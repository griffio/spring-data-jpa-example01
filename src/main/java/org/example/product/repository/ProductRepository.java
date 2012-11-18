package org.example.product.repository;

import org.example.dao.annotation.ExampleRepository;
import org.example.product.domain.ProductEntity;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

@ExampleRepository
public interface ProductRepository extends CrudRepository<ProductEntity, Long>, QueryDslPredicateExecutor<ProductEntity> {

}
