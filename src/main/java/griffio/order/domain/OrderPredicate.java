package griffio.order.domain;

import com.mysema.query.types.Predicate;

import static griffio.order.domain.QOrderEntity.orderEntity;

public final class OrderPredicate {

    private OrderPredicate() {
    }

    public static Predicate findById(Long id) {
        return orderEntity.id.eq(id);
    }

}
