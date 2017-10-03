package platform.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import platform.gateway.entity.AppUserDetails;
import platform.gateway.service.AppUserDetailsService;

import java.util.Collection;

/**
 * 登陆验证
 */
@Component
public class AppAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AppUserDetailsService appUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = (String) authentication.getCredentials();
        AppUserDetails user = (AppUserDetails) appUserDetailsService.loadUserByUsername(login);
        if(user == null){
            throw new BadCredentialsException("Username not found.");
        }

        //加密过程在这里体现
        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("Wrong password.");
        }
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}