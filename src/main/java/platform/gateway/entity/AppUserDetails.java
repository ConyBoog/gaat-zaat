package platform.gateway.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;
import java.util.List;

/**
 * AppUserDetails代表了Spring Security的用户认证实体，带有用户名、密码、权限列表、过期特性等性质
 */

public class AppUserDetails extends User implements org.springframework.security.core.userdetails.UserDetails {

    private List<Role> roles;

    public AppUserDetails(){}

    public AppUserDetails(User user, List<Role> roles){
        super(user);
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(roles == null || roles.size() <1){
            return AuthorityUtils.commaSeparatedStringToAuthorityList("");
        }
        StringBuilder commaBuilder = new StringBuilder();
        for(Role role : roles){
            commaBuilder.append(role.getRoleName()).append(",");
        }
        String authorities = commaBuilder.substring(0,commaBuilder.length()-1);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
