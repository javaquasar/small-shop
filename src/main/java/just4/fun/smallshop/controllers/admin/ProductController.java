package just4.fun.smallshop.controllers.admin;

import just4.fun.smallshop.controllers.admin.forms.ProductForm;
import just4.fun.smallshop.controllers.converters.ProductConverter;
import just4.fun.smallshop.controllers.exceptions.ResourceNotFoundException;
import just4.fun.smallshop.model.product.Product;
import just4.fun.smallshop.services.AttributeTypeService;
import just4.fun.smallshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static just4.fun.smallshop.controllers.ControllerConstants.*;
import static just4.fun.smallshop.controllers.ControllerConstants.ADMIN_PATH;

@Controller
@RequestMapping("/product")
public class ProductController {

    public static final String PRODUCT_PATH = ADMIN_PATH + "product/";

    @Autowired
    private ProductService productService;

    @Autowired
    private AttributeTypeService attributeTypeService;

    @Autowired
    private ProductConverter productConverter;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return PRODUCT_PATH + "list";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("productForm", new ProductForm());
        model.addAttribute("types", attributeTypeService.findAll());
        return PRODUCT_PATH + "edit";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
//        TODO | fire 404 if there isn't product with id in the DB
        ProductForm productForm = productConverter.modelToForm(productService.find(id));
        if (productForm == null) {
            throw new ResourceNotFoundException();
        }
        model.addAttribute("productForm", productForm);
        model.addAttribute("types", attributeTypeService.findAll());
        return PRODUCT_PATH + "edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute("productForm") ProductForm productForm) {
        Product product = productConverter.formToModel(productForm);
        productService.saveOrUpdate(product);
        return "redirect:show/" + product.getId();
    }

    @RequestMapping("/show/{id}")
    public String save(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.find(id));
        return PRODUCT_PATH + "show";
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public AttributeTypeService getAttributeTypeService() {
        return attributeTypeService;
    }

    public void setAttributeTypeService(AttributeTypeService attributeTypeService) {
        this.attributeTypeService = attributeTypeService;
    }
}
