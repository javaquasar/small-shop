package just4.fun.smallshop.api;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import just4.fun.smallshop.api.dto.ProductSearchDto;
import just4.fun.smallshop.dao.ProductDao;
import just4.fun.smallshop.dao.impl.ProductDaoImpl;
import just4.fun.smallshop.json.JacksonMixIn;
import just4.fun.smallshop.model.Test;
import just4.fun.smallshop.model.product.Product;
import just4.fun.smallshop.services.ProductService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import zinjvi.controller.BaseRestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
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

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public List<Product> search(@RequestBody ProductSearchDto productSearchDto) {
        return productService.search(productSearchDto);
    }

}
