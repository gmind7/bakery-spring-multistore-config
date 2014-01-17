package com.gmind7.bakery.test.jpa;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QBaker is a Querydsl query type for Baker
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBaker extends EntityPathBase<Baker> {

    private static final long serialVersionUID = 455382709L;

    public static final QBaker baker = new QBaker("baker");

    public final org.springframework.data.jpa.domain.QAbstractPersistable _super = new org.springframework.data.jpa.domain.QAbstractPersistable(this);

    public final StringPath firstname = createString("firstname");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastname = createString("lastname");

    public final StringPath username = createString("username");

    public QBaker(String variable) {
        super(Baker.class,  forVariable(variable));
    }

    public QBaker(Path<? extends Baker> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaker(PathMetadata<?> metadata) {
        super(Baker.class,  metadata);
    }

}

