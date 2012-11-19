package org.example.order.repository;

import org.example.dao.annotation.ExampleRepository;
import org.example.order.domain.OrderEntity;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

@ExampleRepository
public interface OrderRepository extends CrudRepository<OrderEntity, Long>, QueryDslPredicateExecutor<OrderEntity>, Order {

}
