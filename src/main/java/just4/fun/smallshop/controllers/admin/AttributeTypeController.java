package just4.fun.smallshop.controllers.admin;

import just4.fun.smallshop.services.AttributeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zinchenko on 28.01.15.
 */
@Controller()
@RequestMapping("/attributeType")
public class AttributeTypeController {

    @Autowired
    private AttributeTypeService attributeTypeService;

    @RequestMapping(value = "/list")
    public String list(Model model) {
        model.addAttribute("attributeTypes", attributeTypeService.findAll());
        return "admin/attributeType/list";
    }

//    @RequestMapping(value = "/save")
//    public String save() {
//
//    }
//
//    public static class AttributeTypeData {
//        private String value;
//        private Long
//    }


}
