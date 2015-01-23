package just4.fun.smallshop.api;

import just4.fun.smallshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zinjvi.controller.BaseRestController;

@Controller
@RequestMapping(value = "/product")
public class ProductApi extends BaseRestController{

    private ProductService productService;

    @Autowired
    protected ProductApi(ProductService service) {
        super(service);
        productService = service;
    }

}
