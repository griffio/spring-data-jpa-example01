package org.example.order.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QOrderView is a Querydsl query type for OrderView
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QOrderView extends EntityPathBase<OrderView> {

    private static final long serialVersionUID = 1375999543L;

    public static final QOrderView orderView = new QOrderView("orderView");

    public QOrderView(String variable) {
        super(OrderView.class, forVariable(variable));
    }

    public QOrderView(Path<? extends OrderView> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderView(PathMetadata<?> metadata) {
        super(OrderView.class, metadata);
    }

}

