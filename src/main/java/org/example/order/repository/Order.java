package org.example.order.repository;

import org.example.order.domain.OrderEntity;

public interface Order {

    OrderEntity findOrderItems(Long orderId);

}
