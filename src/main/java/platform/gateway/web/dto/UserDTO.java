package platform.gateway.web.dto;

import com.sun.org.apache.xpath.internal.operations.Bool;
import platform.gateway.entity.enumeration.Gender;

import java.io.Serializable;
import java.util.Date;

/**
 * The DTO of entity User.
 */
public class UserDTO implements Serializable {

    private String id;

    private String name;

    private String password;

    private String login;

    private String phoneNumber;

    private String email;

    private Gender gender;

    private String identityCardNumber;

    private Date birthday;

    private Date createdDate;

    private Date updatedDate;

    private Bool deleted;

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

    public Bool getDeleted() {
        return deleted;
    }

    public void setDeleted(Bool deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", identityCardNumber='" + identityCardNumber + '\'' +
                ", birthday=" + birthday +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", deleted=" + deleted +
                '}';
    }
}
