package just4.fun.smallshop.api;

import just4.fun.smallshop.model.product.AttributeType;
import just4.fun.smallshop.services.AttributeTypeService;
import just4.fun.smallshop.services.CategoryService;
import just4.fun.smallshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zinjvi.controller.BaseRestController;

import java.util.List;

@Controller
@RequestMapping(value = "/category")
public class CategoryApi extends BaseRestController{

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AttributeTypeService attributeTypeService;

    @Autowired
    protected CategoryApi(CategoryService service) {
        super(service);
    }

    @RequestMapping("/attributes/{subCategoryId}")
    @ResponseBody
    public List<AttributeType> getAttributes(
            @PathVariable("subCategoryId") Long subCategoryId) {
        return attributeTypeService.findBySubCategoryId(subCategoryId);
    }

}
