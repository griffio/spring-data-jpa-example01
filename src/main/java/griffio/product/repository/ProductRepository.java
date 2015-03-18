package griffio.product.repository;

import griffio.dao.annotation.ExampleRepository;
import griffio.product.domain.ProductEntity;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

@ExampleRepository
public interface ProductRepository extends CrudRepository<ProductEntity, Long>, QueryDslPredicateExecutor<ProductEntity> {

}
