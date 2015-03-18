package griffio.order.repository;

import griffio.order.domain.OrderEntity;

import java.math.BigDecimal;

public interface Order {

    OrderEntity findOrderItems(Long orderId);

    BigDecimal totalCost(Long orderId);

}
