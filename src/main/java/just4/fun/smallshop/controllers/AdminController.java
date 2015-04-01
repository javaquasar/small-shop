package just4.fun.smallshop.controllers;

import just4.fun.smallshop.controllers.constants.PagePathConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zinchenko on 30.03.15.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/show")
    public String show() {
        return PagePathConstants.ADMIN_FOLDER_NAME + "/index";
    }

}
