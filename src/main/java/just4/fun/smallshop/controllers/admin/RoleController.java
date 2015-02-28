package just4.fun.smallshop.controllers.admin;

import just4.fun.smallshop.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zinchenko on 28.02.15.
 */
@RequestMapping(value = "/role")
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/list")
    public String list(Model model) {
        model.addAttribute("roles", roleService.findAll());
        return "admin/role/list";
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}
