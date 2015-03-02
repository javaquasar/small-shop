package just4.fun.smallshop.services.impl;

import just4.fun.smallshop.dao.OrderDao;
import just4.fun.smallshop.dto.OrderDto;
import just4.fun.smallshop.model.identity.User;
import just4.fun.smallshop.model.order.Order;
import just4.fun.smallshop.model.order.OrderItem;
import just4.fun.smallshop.model.product.Product;
import just4.fun.smallshop.services.OrderService;
import just4.fun.smallshop.services.UserService;
import just4.fun.smallshop.session.CartSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zinjvi.service.impl.BaseService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zinchenko on 02.03.15.
 */
@Service
public class OrderServiceImpl extends BaseService<Order, Long> implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserService userService;

    @Autowired
    private CartSession cartSession;

    @Autowired
    public OrderServiceImpl(OrderDao repository) {
        super(repository);
    }

    @Override
    @Transactional
    public void order(OrderDto orderDto) {
        User user = new User();
        user.setEmail(orderDto.getEmail());
        userService.save(user);

        Order order = new Order();

        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        for (Long productId: cartSession.getProductIds()) {
            OrderItem orderItem = new OrderItem();
            //TODO | support number
            orderItem.setNumber(1);
            orderItem.setProduct(new Product(productId));
            orderItems.add(orderItem);
            orderItem.setOrder(order);
        }


        order.setOrderItems(orderItems);
        order.setUser(user);
        orderDao.save(order);
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public CartSession getCartSession() {
        return cartSession;
    }

    public void setCartSession(CartSession cartSession) {
        this.cartSession = cartSession;
    }
}
