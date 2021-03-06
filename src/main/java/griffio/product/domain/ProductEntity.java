package griffio.product.domain;

import griffio.dao.domain.AbstractPersistableSequence;
import griffio.dao.hibernate.SkuType;
import org.hibernate.annotations.TypeDef;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;

@SuppressWarnings("JpaDataSourceORMInspection")

@Entity()
@Table(name = "PRODUCT_ITEM")
@SequenceGenerator(name = "sequence", sequenceName = "PRODUCT_ITEM_SEQ", initialValue = 1, allocationSize = 1)
@AttributeOverride(name = "id", column = @Column(name = "PRODUCT_ID"))
@TypeDef(defaultForType = Sku.class, typeClass = SkuType.class)
public class ProductEntity extends AbstractPersistableSequence {

  private static final long serialVersionUID = -42L;

  @Column(name = "product_sku")
  private Sku productCode;
  @Column(name = "product_cost")
  private BigDecimal cost;

  protected ProductEntity() {
  }

  public ProductEntity(Long id, Sku productCode, BigDecimal cost) {
    setId(id);
    this.productCode = productCode;
    this.cost = cost;
  }

  public Sku getProductCode() {
    return productCode;
  }

  public BigDecimal getCost() {
    return cost;
  }

}
