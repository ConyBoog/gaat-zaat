package platform.gateway.web.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import platform.gateway.security.AuthService;
import platform.gateway.security.LoginNamePasswordRequest;
import platform.gateway.security.LoginResponse;

/**
 * Login gateway.
 */
@RestController
@RequestMapping("/")
public class LoginResource {

    private Logger logger = LoggerFactory.getLogger(LoginResource.class);

    @Autowired
    protected AuthService authService;

    @RequestMapping( value = "login"
            , method = RequestMethod.POST)
    public ResponseEntity<LoginResponse> doLogin(@RequestBody LoginNamePasswordRequest loginRequest) throws AuthenticationException {
        logger.info("CONY01030: request -> {},", loginRequest);
        if (loginRequest.getLogin() == null || loginRequest.getPassword() == null) {
            throw new BadCredentialsException("User name or password is empty.");
        }
        final String token = authService.login(loginRequest.getLogin(), loginRequest.getPassword());
        LoginResponse response = new LoginResponse();
        response.setToken(token);
        return ResponseEntity.ok(response);
    }
}
