package just4.fun.smallshop.controllers.site;

import just4.fun.smallshop.controllers.constants.PagePathConstants;
import just4.fun.smallshop.model.product.Category;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static just4.fun.smallshop.controllers.constants.PagePathConstants.SITE_FOLDER_NAME;

/**
 * Created by zinchenko on 28.02.15.
 */
@Controller
@RequestMapping("/site")
public class SiteController {

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("/show")
    public String site() {
        return SITE_FOLDER_NAME + "/site";
    }

}
