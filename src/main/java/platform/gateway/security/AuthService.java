package platform.gateway.security;

import platform.gateway.entity.User;

public interface AuthService {
    User register(User user);
    String login(String login, String password);
    String refresh(String oldToken);
}
