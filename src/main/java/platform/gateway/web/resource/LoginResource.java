package platform.gateway.web.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import platform.gateway.entity.AppUserDetails;
import platform.gateway.security.AppAuthenticationProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Login gateway.
 */
@Controller
@RequestMapping("/")
public class LoginResource {

    private Logger logger = LoggerFactory.getLogger(LoginResource.class);

    @Autowired
    private AppAuthenticationProvider authenticationProvider;

    @RequestMapping( value = "login"
            , method = RequestMethod.POST)
    public String doLogin (@RequestParam String login, @RequestParam String password, HttpServletRequest request) throws AuthenticationException {
        logger.info("CONY01030: login -> {},", login);
        if (login == null || password == null) {
            throw new BadCredentialsException("User name or password is empty.");
        }
        Authentication authentication = new UsernamePasswordAuthenticationToken(login, password);
        authentication = authenticationProvider.authenticate(authentication);
        HttpSession session = request.getSession();
        session.setAttribute("login", login);
        session.setAttribute("name", authentication.getName());
        AppUserDetails appUserDetails = new AppUserDetails();
        appUserDetails.setName(authentication.getName());
        request.setAttribute("userDetails", appUserDetails);
        return "/home";
    }
}
