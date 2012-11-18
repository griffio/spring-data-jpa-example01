package org.example.order.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QOrderItemEntity is a Querydsl query type for OrderItemEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QOrderItemEntity extends EntityPathBase<OrderItemEntity> {

    private static final long serialVersionUID = 1204606696;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QOrderItemEntity orderItemEntity = new QOrderItemEntity("orderItemEntity");

    public final org.example.dao.domain.QAbstractPersistableSequence _super = new org.example.dao.domain.QAbstractPersistableSequence(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QOrderEntity order;

    public final org.example.product.domain.QProductEntity product;

    public QOrderItemEntity(String variable) {
        this(OrderItemEntity.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QOrderItemEntity(Path<? extends OrderItemEntity> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QOrderItemEntity(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QOrderItemEntity(PathMetadata<?> metadata, PathInits inits) {
        this(OrderItemEntity.class, metadata, inits);
    }

    public QOrderItemEntity(Class<? extends OrderItemEntity> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.order = inits.isInitialized("order") ? new QOrderEntity(forProperty("order")) : null;
        this.product = inits.isInitialized("product") ? new org.example.product.domain.QProductEntity(forProperty("product")) : null;
    }

}

