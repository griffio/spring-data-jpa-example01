package org.example.product.domain;

public class ProductEntityBuilder {

    private Long id;
    private Sku productCode;

    public ProductEntityBuilder() {
    }

    public ProductEntityBuilder id (Long id) {
        this.id = id;
        return this;
    }

    public ProductEntityBuilder productCode (Sku productCode) {
        this.productCode = productCode;
        return this;
    }

    public ProductEntity build() {
        return new ProductEntity(id, productCode);
    }

}
