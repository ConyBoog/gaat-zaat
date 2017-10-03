package platform.gateway.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import platform.gateway.entity.AppUserDetails;
import platform.gateway.entity.Role;
import platform.gateway.entity.User;
import platform.gateway.repository.RoleRepository;
import platform.gateway.repository.UserRepository;

import java.util.List;

/**
 * User Service.
 */

@Service
@Transactional
public class AppUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(AppUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(login)) {
            logger.info("CONY01000: User login is empty.");
            throw new UsernameNotFoundException("User login is empty.");
        }
        User user;
        try {
            user = userRepository.findByLogin(login);
        } catch (Exception e) {
            logger.error("CONY01040: Query user failed.", e);
            throw new UsernameNotFoundException("Query user failed.");
        }
        if (user == null) {
            logger.info("CONY01010: Can't find user by login {}", login);
            throw new UsernameNotFoundException("User not found.");
        }
        List<Role> roles;
        try {
            roles = roleRepository.findByUserId(user.getId());
        } catch (Exception e) {
            logger.info("CONY01020: Can't find {}'s roles.", login);
            throw new UsernameNotFoundException("Query user roles failed.");
        }
        return new AppUserDetails(user, roles);
    }
}
