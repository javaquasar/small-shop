package just4.fun.smallshop.services;

import just4.fun.smallshop.dto.OrderDto;
import just4.fun.smallshop.model.order.Order;
import zinjvi.service.Service;

/**
 * Created by zinchenko on 02.03.15.
 */
public interface OrderService extends Service<Order, Long> {

    void order(OrderDto orderDto);

}
