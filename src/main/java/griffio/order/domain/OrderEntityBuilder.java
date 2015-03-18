package griffio.order.domain;

import org.joda.time.LocalDateTime;

public class OrderEntityBuilder {
    
    private Long id;
    private LocalDateTime created;

    public OrderEntityBuilder() {
    }

    public OrderEntityBuilder id (Long id) {
        this.id = id;
        return this;        
    }
    
    public OrderEntityBuilder created (LocalDateTime created) {
        this.created = created;
        return this;        
    }

    public OrderEntity build() {
        return new OrderEntity(id, created);
    }
    
}
