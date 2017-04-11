package platform.gateway.web.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Route to index.
 */
@Controller
public class MainResource {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
