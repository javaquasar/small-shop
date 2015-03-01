package just4.fun.smallshop.api;

import just4.fun.smallshop.model.product.Product;
import just4.fun.smallshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import zinjvi.controller.BaseRestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

//TODO move api to separate servlet
@Controller
@RequestMapping(value = "/product")
public class ProductApi extends BaseRestController<Product, Long> {

    public static final String CART_ITEMS_KEY = "cart-items";
    private ProductService productService;

    @Autowired
    protected ProductApi(ProductService service) {
        super(service);
        productService = service;
    }

    @RequestMapping(value = "/bySubCategoryId/{subCategoryId}")
    @ResponseBody
    public List<Product> getBySubCategoryId(@PathVariable("subCategoryId") Long subCategoryId) {
        return productService.getBySubCategoryId(subCategoryId);
    }

    @RequestMapping("/filter/subCategory/{subCategoryId}/attributeValue/{attributeValueId}")
    @ResponseBody
    public List<Product> filter(
            @PathVariable("subCategoryId") Long subCategoryId,
            @PathVariable("attributeValueId") Long attributeValueId) {
        return productService.getBySubCategoryIdAndAttrValueId(subCategoryId, attributeValueId);
    }

}
