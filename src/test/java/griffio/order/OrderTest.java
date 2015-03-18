package griffio.order;

import griffio.config.ApplicationConfiguration;
import griffio.order.domain.OrderEntity;
import griffio.order.domain.OrderEntityBuilder;
import griffio.order.repository.OrderRepository;
import griffio.product.domain.ProductEntity;
import griffio.product.domain.ProductPredicate;
import griffio.product.domain.Sku;
import griffio.product.repository.ProductRepository;
import griffio.truth.CompareSubject;
import org.joda.time.LocalDateTime;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.math.BigDecimal;

import static com.google.common.truth.Truth.ASSERT;


@Test
@ContextConfiguration(classes = ApplicationConfiguration.class)
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

        ASSERT.that(first.getId()).isNotNull();
        ASSERT.that(first.getCreated()).isNotNull();

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
        ASSERT.that(first.getId()).isNotNull();
        ASSERT.that(first.getCreated()).isNotNull();
        ASSERT.that(first.getItems().size()).isEqualTo(2);

        BigDecimal sum2 = orderRepository.totalCost(first.getId());

        ASSERT.about(CompareSubject.create).that(sum2).comparesEqualTo(new BigDecimal("4.98"));

    }

}
