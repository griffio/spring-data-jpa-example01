package org.example.product.domain;

import java.math.BigDecimal;

public class ProductEntityBuilder {

    private Long id;
    private Sku code;
    private BigDecimal cost;

    public ProductEntityBuilder() {
    }

    public ProductEntityBuilder id (Long id) {
        this.id = id;
        return this;
    }

    public ProductEntityBuilder code (Sku code) {
        this.code = code;
        return this;
    }

    public ProductEntityBuilder cost (BigDecimal cost) {
        this.cost = cost;
        return this;
    }

    public ProductEntity build() {
        return new ProductEntity(id, code, cost);
    }



}
