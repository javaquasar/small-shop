package just4.fun.smallshop.api;

import just4.fun.smallshop.dto.CartDto;
import just4.fun.smallshop.dto.OrderDto;
import just4.fun.smallshop.services.OrderService;
import just4.fun.smallshop.session.CartSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zinchenko on 01.03.15.
 */
@Controller
@RequestMapping("/cart")
public class CartApi {

    @Autowired
    private CartSession cartSession;

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void addToCart(@RequestBody Long productId) {
        cartSession.addToCart(productId);
    }

    @RequestMapping("/cartItems")
    @ResponseBody
    public List<Long> cartItems(HttpSession session) {
        return cartSession.getCart().getProductIds();
    }

    @RequestMapping
    @ResponseBody
    public CartDto getCart() {
        return cartSession.getCart();
    }

    @RequestMapping("/order")
    @ResponseBody
    public void order(@RequestBody OrderDto orderDto) {
        orderService.order(orderDto);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public void clean() {
        cartSession.cleanCart();
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void clean(@PathVariable("productId") Long productId) {
        cartSession.removeFromCart(productId);
    }

}
