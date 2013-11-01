package org.example.order.repository;

import org.example.order.domain.OrderEntity;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.math.BigDecimal;

import static org.example.order.domain.QOrderEntity.orderEntity;
import static org.example.order.domain.QOrderItemEntity.orderItemEntity;

public class OrderRepositoryExtension extends QueryDslRepositorySupport implements Order {

    public OrderRepositoryExtension() {
        super(Order.class);
    }

    @Override
    public OrderEntity findOrderItems(Long orderId) {
        return from(orderEntity)
                .innerJoin(orderEntity.items).fetch()
                .where(orderEntity.id.eq(orderId))
                .singleResult(orderEntity);
    }

    @Override
    public BigDecimal totalCost(Long orderId) {
        return from(orderItemEntity)
                .where(orderItemEntity.order.id.eq(orderId))
                .uniqueResult(orderItemEntity.product.cost.sum());
    }

}