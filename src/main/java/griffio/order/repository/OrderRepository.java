package griffio.order.repository;

import griffio.dao.annotation.ExampleRepository;
import griffio.order.domain.OrderEntity;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

@ExampleRepository
public interface OrderRepository extends CrudRepository<OrderEntity, Long>, QueryDslPredicateExecutor<OrderEntity>, Order {

}
