package org.example.product.domain;

import com.mysema.query.types.Predicate;

import static org.example.product.domain.QProductEntity.productEntity;

public final class ProductPredicate {

    private ProductPredicate() {
    }

    public static Predicate findByProductCode(Sku sku) {
        return productEntity.productCode.eq(sku);
    }

}
