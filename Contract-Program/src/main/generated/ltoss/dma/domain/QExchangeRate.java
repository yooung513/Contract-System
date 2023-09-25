package ltoss.dma.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QExchangeRate is a Querydsl query type for ExchangeRate
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QExchangeRate extends EntityPathBase<ExchangeRate> {

    private static final long serialVersionUID = 298223696L;

    public static final QExchangeRate exchangeRate = new QExchangeRate("exchangeRate");

    public final StringPath bkpr = createString("bkpr");

    public final DatePath<java.time.LocalDate> curDate = createDate("curDate", java.time.LocalDate.class);

    public final StringPath curNm = createString("curNm");

    public final StringPath curUnit = createString("curUnit");

    public final StringPath dealBasR = createString("dealBasR");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final StringPath kftcBkpr = createString("kftcBkpr");

    public final StringPath kftcDealBasR = createString("kftcDealBasR");

    public final NumberPath<Long> result = createNumber("result", Long.class);

    public final StringPath tenDdEfeeR = createString("tenDdEfeeR");

    public final StringPath ttb = createString("ttb");

    public final StringPath tts = createString("tts");

    public final StringPath yyEfeeR = createString("yyEfeeR");

    public QExchangeRate(String variable) {
        super(ExchangeRate.class, forVariable(variable));
    }

    public QExchangeRate(Path<? extends ExchangeRate> path) {
        super(path.getType(), path.getMetadata());
    }

    public QExchangeRate(PathMetadata metadata) {
        super(ExchangeRate.class, metadata);
    }

}

