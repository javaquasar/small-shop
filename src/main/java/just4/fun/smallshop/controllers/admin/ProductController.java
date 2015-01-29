package just4.fun.smallshop.controllers.admin;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import just4.fun.smallshop.controllers.admin.forms.ProductForm;
import just4.fun.smallshop.model.AttributeType;
import just4.fun.smallshop.model.Product;
import just4.fun.smallshop.model.ProductAttribute;
import just4.fun.smallshop.services.AttributeTypeService;
import just4.fun.smallshop.services.ProductService;
import ml.rugal.sshcommon.springmvc.bind.annotation.FormModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static just4.fun.smallshop.controllers.admin.forms.ProductForm.AttributeFormData;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private AttributeTypeService attributeTypeService;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return "admin/product/list";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", attributeTypeService.findAll());
        return "admin/product/edit";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.find(id));
        model.addAttribute("types", attributeTypeService.findAll());
        return "admin/product/edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute("product") ProductForm productForm) {
        Product product = extractProduct(productForm);
        productService.save(product);
        return "redirect:show/" + product.getId();
    }

    private Product extractProduct(ProductForm productForm) {
        Product product = new Product();
        product.setName(productForm.getTitle());
        List<ProductAttribute> attributes = extractAttributes(productForm.getAttributes(), product);
        product.setProductAttributes(attributes);
        return product;
    }

    private List<ProductAttribute> extractAttributes(List<AttributeFormData> attributeFormDatas, final Product product) {
        return Lists.transform(attributeFormDatas, new Function<AttributeFormData, ProductAttribute>() {
            @Override
            public ProductAttribute apply(AttributeFormData attributeFormData) {
                ProductAttribute attribute = new ProductAttribute();
                attribute.setAttributeType(new AttributeType(attributeFormData.getAttributeTypeId()));
                attribute.setStringValue(attributeFormData.getValue());
                attribute.setProduct(product);
                return attribute;
            }
        });
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
