package just4.fun.smallshop.session.impl;

import just4.fun.smallshop.dto.CartDto;
import just4.fun.smallshop.services.ProductService;
import just4.fun.smallshop.session.CartSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zinchenko on 01.03.15.
 */
@Component
@Scope(value = "session", proxyMode= ScopedProxyMode.INTERFACES)
public class CartSessionImpl implements CartSession {

    private List<Long> productIds = new ArrayList<Long>();

    @Autowired
    private ProductService productService;

    @Override
    public void addToCart(Long productId) {
        productIds.add(productId);
    }

    @Override
    public void removeFromCart(Long productId) {
        productIds.remove(productId);
    }

    @Override
    public void cleanCart() {
        productIds.clear();
    }

    @Override
    public CartDto getCart() {
        CartDto cart = new CartDto();
        cart.setProductIds(productIds);
        if(!productIds.isEmpty()) {
            cart.setProducts(productService.findByIds(productIds));
        }
        return cart;
    }

    public List<Long> getProductIds() {
        return productIds;
    }
}
