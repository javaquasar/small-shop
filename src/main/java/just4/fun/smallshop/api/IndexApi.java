package just4.fun.smallshop.api;

import just4.fun.smallshop.services.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zinchenko on 09.03.15.
 */
@Controller
@RequestMapping("/index")
public class IndexApi {

    @Autowired
    private IndexService indexService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Long index() {
        return indexService.index();
    }



}
