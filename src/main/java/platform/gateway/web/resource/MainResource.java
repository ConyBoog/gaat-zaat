package platform.gateway.web.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import platform.gateway.security.SecurityUtils;

/**
 * Route to index.
 */
@Controller
public class MainResource {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping("/userItem/index")
    public String userItemIndex() {
        String currentLogin = SecurityUtils.getCurrentUserLogin();
        System.out.println(currentLogin);
        return "/item/userItemList";
    }
}
