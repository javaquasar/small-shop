package just4.fun.smallshop.session;

import just4.fun.smallshop.dto.CartDto;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by zinchenko on 01.03.15.
 */
public interface CartSession {

    void addToCart(Long productId);

    void removeFromCart(Long productId);

    void cleanCart();

    CartDto getCart();

}
