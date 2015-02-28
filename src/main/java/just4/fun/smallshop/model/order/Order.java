package just4.fun.smallshop.model.order;

import just4.fun.smallshop.model.BaseEntity;
import just4.fun.smallshop.model.identity.User;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zinchenko on 27.02.15.
 */
@Entity
@Table(name = "order")
public class Order extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
