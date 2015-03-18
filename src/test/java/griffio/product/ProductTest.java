package griffio.product;

import griffio.config.ApplicationConfiguration;
import griffio.product.domain.ProductEntity;
import griffio.product.repository.ProductRepository;
import griffio.product.domain.ProductEntityBuilder;
import griffio.product.domain.ProductPredicate;
import griffio.product.domain.Sku;
import griffio.truth.CompareSubject;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.annotations.Test;

import javax.inject.Inject;

import java.math.BigDecimal;

import static com.google.common.truth.Truth.ASSERT;

@ContextConfiguration(classes = ApplicationConfiguration.class)
@TransactionConfiguration(defaultRollback = false)
public class ProductTest extends AbstractTestNGSpringContextTests {

    private final ProductEntityBuilder productBuilder = new ProductEntityBuilder();

    private final Sku fixture = new Sku("Z1");

    @Inject
    private ProductRepository productRepository;

    @Test
    public void saveOrder() {

        productBuilder.code(fixture).cost(new BigDecimal("10.0"));

        ProductEntity productEntity = productBuilder.build();

        productRepository.save(productEntity);
    }

    @Test(dependsOnMethods = {"saveOrder"})
    public void findProduct() {

        ProductEntity first = productRepository.findOne(ProductPredicate.findByProductCode(fixture));

        ASSERT.that(first.getId()).isNotNull();
        ASSERT.about(CompareSubject.create).that(first.getCost()).comparesEqualTo(new BigDecimal("10.0"));
        ASSERT.that(first.getProductCode()).isEqualTo(fixture);

    }

}