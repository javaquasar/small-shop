package just4.fun.smallshop.dto;

import just4.fun.smallshop.model.product.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zinchenko on 01.03.15.
 */
public class CartDto {

    private List<Long> productIds = new ArrayList<Long>();

    private List<Product> products = new ArrayList<Product>();

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
