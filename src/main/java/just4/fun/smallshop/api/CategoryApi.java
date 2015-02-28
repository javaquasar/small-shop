package just4.fun.smallshop.api;

import just4.fun.smallshop.services.CategoryService;
import just4.fun.smallshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zinjvi.controller.BaseRestController;

@Controller
@RequestMapping(value = "/category")
public class CategoryApi extends BaseRestController{

    private CategoryService categoryService;

    @Autowired
    protected CategoryApi(CategoryService service) {
        super(service);
        categoryService = service;
    }

}
