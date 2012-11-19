package org.example.order.repository;

import org.example.order.domain.OrderEntity;
import org.example.order.domain.QOrderEntity;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

public class OrderRepositoryExtension extends QueryDslRepositorySupport implements Order {

    public OrderRepositoryExtension() {
    }

    @Override
    public OrderEntity findOrderItems(Long orderId) {
        return from(QOrderEntity.orderEntity)
                .innerJoin(QOrderEntity.orderEntity.items).fetch()
                .where(QOrderEntity.orderEntity.id.eq(orderId))
                .singleResult(QOrderEntity.orderEntity);
    }
}
