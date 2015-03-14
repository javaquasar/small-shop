package just4.fun.smallshop.controllers.admin;

import just4.fun.smallshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static just4.fun.smallshop.controllers.ControllerConstants.ADMIN_PATH;

/**
 * Created by zinchenko on 11.03.15.
 */
@RequestMapping("/order")
@Controller
public class OrderController {

    public static final String ORDER_PATH = ADMIN_PATH + "order/";

    @Autowired
    private OrderService orderService;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return ORDER_PATH + "list";
    }

    @RequestMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        return ORDER_PATH + "list";
    }

    @RequestMapping("/show/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("order", orderService.find(id));
        return ORDER_PATH + "show";
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
