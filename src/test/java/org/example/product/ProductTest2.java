package org.example.product;

import org.example.product.domain.ProductEntity;
import org.example.product.domain.ProductEntityBuilder;
import org.example.product.domain.Sku;
import org.example.product.repository.ProductRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static com.mysema.query.collections.CollQueryFactory.from;
import static com.mysema.query.group.GroupBy.groupBy;
import static com.mysema.query.group.GroupBy.list;
import static org.example.product.domain.QProductEntity.productEntity;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ContextConfiguration(locations = "/org/example/product/ProductTest-context.xml")
public class ProductTest2 extends AbstractTestNGSpringContextTests {

    private ProductEntityBuilder productBuilder = new ProductEntityBuilder();

    private final Sku a1 = new Sku("A1");
    private final Sku b2 = new Sku("B2");
    private final Sku c3 = new Sku("C3");
    private final Sku d4 = new Sku("D4");
    private final Sku e5 = new Sku("E5");

    @Inject
    private ProductRepository productRepository;

    @Test
    public void saveOrder() {

        ProductEntity productEntity1 = productBuilder.code(a1).cost(new BigDecimal("10.50")).build();
        ProductEntity productEntity2 = productBuilder.code(b2).cost(new BigDecimal("11.50")).build();
        ProductEntity productEntity3 = productBuilder.code(c3).cost(new BigDecimal("12.50")).build();
        ProductEntity productEntity4 = productBuilder.code(d4).cost(new BigDecimal("11.50")).build();
        ProductEntity productEntity5 = productBuilder.code(e5).cost(new BigDecimal("10.50")).build();

        productRepository.save(productEntity1);
        productRepository.save(productEntity2);
        productRepository.save(productEntity3);
        productRepository.save(productEntity4);
        productRepository.save(productEntity5);

    }

    @Test(dependsOnMethods = {"saveOrder"})
    public void findProduct() {

        Iterable<ProductEntity> allProducts = productRepository.findAll();

        BigDecimal totalCost = from(productEntity, allProducts).singleResult(productEntity.cost.sum());

        System.out.println("totalCost = " + totalCost);

        Map<BigDecimal, List<ProductEntity>> results = from(productEntity, allProducts)
                .orderBy(productEntity.cost.desc())
                .transform(groupBy(productEntity.cost)
                        .as(list(productEntity)));

        assertThat(results.get(new BigDecimal("10.50")).size(), equalTo(2));

    }

}