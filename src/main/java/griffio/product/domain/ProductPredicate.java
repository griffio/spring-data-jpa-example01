package griffio.product.domain;

import com.mysema.query.types.Predicate;

public final class ProductPredicate {

    private ProductPredicate() {
    }

    public static Predicate findByProductCode(Sku sku) {
        return QProductEntity.productEntity.productCode.eq(sku);
    }

}
