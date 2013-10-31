package org.example.dao.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAbstractPersistableSequence is a Querydsl query type for AbstractPersistableSequence
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QAbstractPersistableSequence extends EntityPathBase<AbstractPersistableSequence> {

    private static final long serialVersionUID = 222442093;

    public static final QAbstractPersistableSequence abstractPersistableSequence = new QAbstractPersistableSequence("abstractPersistableSequence");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QAbstractPersistableSequence(String variable) {
        super(AbstractPersistableSequence.class, forVariable(variable));
    }

    public QAbstractPersistableSequence(Path<? extends AbstractPersistableSequence> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAbstractPersistableSequence(PathMetadata<?> metadata) {
        super(AbstractPersistableSequence.class, metadata);
    }

}

