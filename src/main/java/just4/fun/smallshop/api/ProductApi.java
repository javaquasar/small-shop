package just4.fun.smallshop.api;

import just4.fun.smallshop.beans.Product;
import just4.fun.smallshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductApi {

    @Autowired
    private ProductService service;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getAll() {
        return service.findAll();
    }


}
