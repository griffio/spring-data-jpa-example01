package org.example.order.domain;

import com.google.common.collect.Lists;
import org.example.dao.domain.AbstractPersistableSequence;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@SuppressWarnings("JpaDataSourceORMInspection")

@Entity()
@Table(name = "CUSTOMER_ORDER")
@SequenceGenerator(name = "sequence", sequenceName = "CUSTOMER_ORDER_SEQ", initialValue = 1, allocationSize = 1)
@AttributeOverride(name="id", column=@Column(name="ORDER_ID"))
public class OrderEntity extends AbstractPersistableSequence {

    @Column(name="CREATED", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime created;
    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderItemEntity> items;

    protected OrderEntity() {
    }

    public OrderEntity(Long id, LocalDateTime created) {
        setId(id);
        this.created = created;
        this.items = newArrayList();
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void addItem(OrderItemEntity orderItem) {
        orderItem.setOrder(this);
        items.add(orderItem);
    }

    public List<OrderItemEntity> getItems() {
        return Lists.newArrayList(items);
    }

}
