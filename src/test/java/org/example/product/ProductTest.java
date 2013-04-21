package org.example.product;

import org.example.product.domain.ProductEntity;
import org.example.product.domain.ProductEntityBuilder;
import org.example.product.domain.ProductPredicate;
import org.example.product.domain.Sku;
import org.example.product.repository.ProductRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.inject.Inject;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.number.OrderingComparison.comparesEqualTo;

@ContextConfiguration
public class ProductTest extends AbstractTestNGSpringContextTests {

    private final ProductEntityBuilder productBuilder = new ProductEntityBuilder();

    private final Sku a1 = new Sku("A1");

    @Inject
    private ProductRepository productRepository;

    @Test
    public void saveOrder() {

        productBuilder.code(a1).cost(new BigDecimal("10.0"));

        ProductEntity productEntity = productBuilder.build();

        productRepository.save(productEntity);
    }

    @Test(dependsOnMethods = {"saveOrder"})
    public void findProduct() {

        ProductEntity first = productRepository.findOne(ProductPredicate.findByProductCode(a1));

        assertThat(first.getId(), notNullValue());
        assertThat(first.getCost(), comparesEqualTo(new BigDecimal("10.0")));
        assertThat(first.getProductCode(), equalTo(a1));
    }

}