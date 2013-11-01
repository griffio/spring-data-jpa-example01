package org.example.order;

import org.example.order.domain.OrderEntity;
import org.example.order.domain.OrderEntityBuilder;
import org.example.order.repository.OrderRepository;
import org.example.product.domain.ProductEntity;
import org.example.product.domain.ProductPredicate;
import org.example.product.domain.Sku;
import org.example.product.repository.ProductRepository;
import org.joda.time.LocalDateTime;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@Test
@ContextConfiguration
public class OrderTest extends AbstractTestNGSpringContextTests {

    private OrderEntityBuilder orderBuilder = new OrderEntityBuilder();

    @Inject
    private OrderRepository orderRepository;

    @Inject
    private ProductRepository productRepository;

    public void saveBasicOrder() {

        orderBuilder.created(new LocalDateTime());
        OrderEntity orderEntity = orderBuilder.build();

        orderRepository.save(orderEntity);

        OrderEntity first = orderRepository.findOne(orderEntity.getId());
        assertThat(first.getId(), notNullValue());
        assertThat(first.getCreated(), notNullValue());

    }

    public void saveOrderItems() {

        orderBuilder.created(new LocalDateTime());
        OrderEntity orderEntity = orderBuilder.build();

        ProductEntity YOLO = productRepository.findOne(ProductPredicate.findByProductCode(new Sku("YOLO")));
        ProductEntity XOXO = productRepository.findOne(ProductPredicate.findByProductCode(new Sku("XOXO")));

        orderEntity.addProductItem(YOLO).setQuantity(1);
        orderEntity.addProductItem(XOXO).setQuantity(3);

        orderRepository.save(orderEntity);

        OrderEntity first = orderRepository.findOrderItems(orderEntity.getId());
        assertThat(first.getId(), notNullValue());
        assertThat(first.getCreated(), notNullValue());
        assertThat(first.getItems().size(), equalTo(2));

        BigDecimal sum2 = orderRepository.totalCost(first.getId());

        assertThat(sum2, comparesEqualTo(new BigDecimal("4.98")));

    }

}
