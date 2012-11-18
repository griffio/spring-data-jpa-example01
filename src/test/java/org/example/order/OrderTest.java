package org.example.order;

import org.example.order.domain.OrderEntity;
import org.example.order.domain.OrderEntityBuilder;
import org.example.order.repository.OrderRepository;
import org.joda.time.LocalDateTime;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@Test
@ContextConfiguration
public class OrderTest extends AbstractTestNGSpringContextTests {

    private OrderEntityBuilder orderBuilder = new OrderEntityBuilder();

    @Inject
    private OrderRepository orderRepository;

    public void saveOrder() {

        orderBuilder.created(new LocalDateTime());
        OrderEntity orderEntity = orderBuilder.build();

        orderRepository.save(orderEntity);

        OrderEntity first = orderRepository.findOne(orderEntity.getId());
        assertThat(first.getId(), notNullValue());
        assertThat(first.getCreated(), notNullValue());

    }

}
