package com.psc.cloud.product.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCode is a Querydsl query type for Code
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCode extends EntityPathBase<Code> {

    private static final long serialVersionUID = -1687035932L;

    public static final QCode code = new QCode("code");

    public final NumberPath<Long> codeId = createNumber("codeId", Long.class);

    public final StringPath codeName = createString("codeName");

    public final StringPath description = createString("description");

    public final BooleanPath enabled = createBoolean("enabled");

    public final NumberPath<Long> parentId = createNumber("parentId", Long.class);

    public QCode(String variable) {
        super(Code.class, forVariable(variable));
    }

    public QCode(Path<? extends Code> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCode(PathMetadata metadata) {
        super(Code.class, metadata);
    }

}

