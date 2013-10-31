package org.example.product.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QProductEntity is a Querydsl query type for ProductEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProductEntity extends EntityPathBase<ProductEntity> {

    private static final long serialVersionUID = 1070125141;

    public static final QProductEntity productEntity = new QProductEntity("productEntity");

    public final org.example.dao.domain.QAbstractPersistableSequence _super = new org.example.dao.domain.QAbstractPersistableSequence(this);

    public final NumberPath<java.math.BigDecimal> cost = createNumber("cost", java.math.BigDecimal.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final SimplePath<Sku> productCode = createSimple("productCode", Sku.class);

    public QProductEntity(String variable) {
        super(ProductEntity.class, forVariable(variable));
    }

    public QProductEntity(Path<? extends ProductEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductEntity(PathMetadata<?> metadata) {
        super(ProductEntity.class, metadata);
    }

}

