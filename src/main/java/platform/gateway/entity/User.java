package platform.gateway.entity;

import javax.persistence.*;
import javax.persistence.Id;

/**
 * 用户
 */
@Entity
@Table(name = "users")
@SuppressWarnings("unused")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;

    private String name;

    private String password;

    private String login;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
