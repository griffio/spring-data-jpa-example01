package org.example.order.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QOrderEntity is a Querydsl query type for OrderEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QOrderEntity extends EntityPathBase<OrderEntity> {

    private static final long serialVersionUID = -996007179L;

    public static final QOrderEntity orderEntity = new QOrderEntity("orderEntity");

    public final org.example.dao.domain.QAbstractPersistableSequence _super = new org.example.dao.domain.QAbstractPersistableSequence(this);

    public final DateTimePath<org.joda.time.LocalDateTime> created = createDateTime("created", org.joda.time.LocalDateTime.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final ListPath<OrderItemEntity, QOrderItemEntity> items = this.<OrderItemEntity, QOrderItemEntity>createList("items", OrderItemEntity.class, QOrderItemEntity.class, PathInits.DIRECT2);

    public QOrderEntity(String variable) {
        super(OrderEntity.class, forVariable(variable));
    }

    public QOrderEntity(Path<? extends OrderEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderEntity(PathMetadata<?> metadata) {
        super(OrderEntity.class, metadata);
    }

}

