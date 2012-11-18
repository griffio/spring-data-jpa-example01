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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@ContextConfiguration
public class ProductTest extends AbstractTestNGSpringContextTests {

    private ProductEntityBuilder productBuilder = new ProductEntityBuilder();

    private final Sku a1 = new Sku("A1");

    @Inject
    private ProductRepository productRepository;

    @Test
    public void saveOrder() {

        productBuilder.productCode(a1);

        ProductEntity productEntity= productBuilder.build();

        productRepository.save(productEntity);

        ProductEntity first = productRepository.findOne(productEntity.getId());
        assertThat(first.getId(), notNullValue());
        assertThat(first.getProductCode(), equalTo(a1));

    }

    @Test(dependsOnMethods={"saveOrder"})
    public void findProduct() {
        ProductEntity first = productRepository.findOne(ProductPredicate.findByProductCode(a1));
        assertThat(first.getProductCode(), equalTo(a1));
    }

}