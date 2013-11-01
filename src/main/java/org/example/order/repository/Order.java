package org.example.order.repository;

import org.example.order.domain.OrderEntity;

import java.math.BigDecimal;

public interface Order {

    OrderEntity findOrderItems(Long orderId);

    BigDecimal totalCost(Long orderId);

}
