package org.example.order.domain;

import org.example.dao.domain.AbstractPersistableSequence;
import org.example.product.domain.ProductEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("JpaDataSourceORMInspection")

@Entity()
@Table(name = "CUSTOMER_ORDER_ITEM")
@SequenceGenerator(name = "sequence", sequenceName = "CUSTOMER_ORDER_ITEM_SEQ", initialValue = 1, allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name = "ORDER_ITEM_ID"))
public class OrderItemEntity extends AbstractPersistableSequence {

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity product;
    @ManyToOne(optional = false)
    private OrderEntity order;

    public OrderItemEntity() {
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public ProductEntity getProduct() {
        return product;
    }

}
