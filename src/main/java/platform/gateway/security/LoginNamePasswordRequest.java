package platform.gateway.security;

/**
 *  接受登陆参数
 */
public class LoginNamePasswordRequest {

    private String login;

    private String password;

    @Override
    public String toString() {
        return "LoginNamePasswordRequest{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
