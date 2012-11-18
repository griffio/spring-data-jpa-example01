package org.example.product.domain;

import com.mysema.query.annotations.PropertyType;
import com.mysema.query.annotations.QueryType;
import org.example.dao.domain.AbstractPersistableSequence;
import org.example.dao.hibernate.SkuType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("JpaDataSourceORMInspection")

@Entity()
@Table(name = "PRODUCT_ITEM")
@SequenceGenerator(name = "sequence", sequenceName = "PRODUCT_ITEM_SEQ", initialValue = 1, allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name = "PRODUCT_ID"))
@TypeDef(defaultForType = Sku.class, typeClass = SkuType.class)
public class ProductEntity extends AbstractPersistableSequence {

    @Column(name = "product_sku")
    private Sku productCode;

    protected ProductEntity() {
    }

    public ProductEntity(Long id, Sku productCode) {
        setId(id);
        this.productCode = productCode;
    }

    public Sku getProductCode() {
        return productCode;
    }

}
