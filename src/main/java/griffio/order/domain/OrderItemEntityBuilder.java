package griffio.order.domain;

import griffio.product.domain.ProductEntity;

public class OrderItemEntityBuilder {

    private Long id;
    private ProductEntity product;
    private OrderEntity order;

    public OrderItemEntityBuilder() {
    }

    public OrderItemEntityBuilder order(OrderEntity order) {
        this.order = order;
        return this;
    }

    public OrderItemEntityBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public OrderItemEntityBuilder product(ProductEntity product) {
        this.product = product;
        return this;
    }

    public OrderItemEntity build() {
        return new OrderItemEntity(id, order, product);
    }

}
