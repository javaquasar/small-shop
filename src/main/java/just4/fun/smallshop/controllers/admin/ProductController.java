package just4.fun.smallshop.controllers.admin;

import just4.fun.smallshop.beans.Product;
import just4.fun.smallshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return "admin/productList";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        return "admin/createProduct";
    }

    @RequestMapping("/save")
    public String save(Model model, Product product) {
        productService.save(product);
        return "redirect:/product/show/" + product.getId();
    }

    @RequestMapping("/show/{id}")
    public String save(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.find(id));
        return "admin/showProduct";
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
