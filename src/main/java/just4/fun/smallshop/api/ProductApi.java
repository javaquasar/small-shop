package just4.fun.smallshop.api;

import just4.fun.smallshop.model.product.Product;
import just4.fun.smallshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zinjvi.controller.BaseRestController;

import java.util.List;

//TODO move api to separate servlet
@Controller
@RequestMapping(value = "/product")
public class ProductApi extends BaseRestController{

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

}
