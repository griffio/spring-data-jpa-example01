package org.example.order.domain;

import com.mysema.query.types.Predicate;

import static org.example.order.domain.QOrderEntity.orderEntity;

public final class OrderPredicate {

    private OrderPredicate() {
    }

    public static Predicate findById(Long id) {
        return orderEntity.id.eq(id);
    }

}
