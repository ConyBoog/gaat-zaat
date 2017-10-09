package platform.gateway.entity;

import platform.gateway.entity.enumeration.Gender;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 */
@Entity
@Table(name = "users")
@SuppressWarnings("unused")
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private String identityCardNumber;

    @Column
    private Date birthday;

    @Column
    private String roles;

    @Column
    private Date createdDate;

    @Column
    private Date updatedDate;

    @Column
    private Boolean deleted;


    public User(){}

    public User(User user){
        this.name = user.getName();
        this.password = user.getPassword();
        this.login = user.getLogin();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
        this.gender = user.getGender();
        this.identityCardNumber = user.getIdentityCardNumber();
        this.roles = user.getRoles();
        this.birthday = user.getBirthday();
        this.id = user.getId();
        this.createdDate = user.getCreatedDate();
        this.updatedDate = user.getUpdatedDate();
        this.deleted = user.getDeleted();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", identityCardNumber='" + identityCardNumber + '\'' +
                ", birthday=" + birthday +
                ", roles=" + roles +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", deleted=" + deleted +
                '}';
    }
}
