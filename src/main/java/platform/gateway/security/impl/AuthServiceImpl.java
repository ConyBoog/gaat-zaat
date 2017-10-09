package platform.gateway.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import platform.gateway.entity.AppUserDetails;
import platform.gateway.entity.User;
import platform.gateway.repository.UserRepository;
import platform.gateway.security.AuthService;
import platform.gateway.security.JWTProvider;
import platform.gateway.service.AppUserDetailsService;

import java.util.Date;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;

    private AppUserDetailsService appUserDetailsService;

    private JWTProvider jwtProvider;

    private UserRepository userRepository;

    private String tokenHead = "Bearer ";

    @Autowired
    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            AppUserDetailsService appUserDetailsService,
            JWTProvider jwtProvider,
            UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.appUserDetailsService = appUserDetailsService;
        this.jwtProvider = jwtProvider;
        this.userRepository = userRepository;
    }


    @Override
    public User register(User user) {
        final String login = user.getLogin();
        if (userRepository.findByLogin(login) != null) {
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = user.getPassword();
        user.setPassword(encoder.encode(rawPassword));
        user.setUpdatedDate(new Date());
        user.setRoles("['USER']");
        user.setId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public String login(String login, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(login, password);
        final Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final AppUserDetails appUserDetails = (AppUserDetails) appUserDetailsService.loadUserByUsername(login);
        return jwtProvider.generateToken(appUserDetails);
    }



    @Override
    public String refresh(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String username = jwtProvider.getUsernameFromToken(token);
        AppUserDetails user = (AppUserDetails) appUserDetailsService.loadUserByUsername(username);
        if (jwtProvider.canTokenBeRefreshed(token, user.getUpdatedDate())){
            return jwtProvider.refreshToken(token);
        }
        return null;
    }
}
