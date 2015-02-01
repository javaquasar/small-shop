package just4.fun.smallshop.controllers.admin;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import just4.fun.smallshop.controllers.admin.forms.ProductForm;
import just4.fun.smallshop.controllers.converters.ProductConverter;
import just4.fun.smallshop.controllers.exceptions.ResourceNotFoundException;
import just4.fun.smallshop.model.AttributeType;
import just4.fun.smallshop.model.Product;
import just4.fun.smallshop.model.ProductAttribute;
import just4.fun.smallshop.services.AttributeTypeService;
import just4.fun.smallshop.services.ProductService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

import static just4.fun.smallshop.controllers.admin.forms.ProductForm.AttributeFormData;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private AttributeTypeService attributeTypeService;

    @Autowired
    private ProductConverter productConverter;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return "admin/product/list";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("productForm", new ProductForm());
        model.addAttribute("types", attributeTypeService.findAll());
        return "admin/product/edit";
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
        return "admin/product/edit";
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
        return "admin/product/show";
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
