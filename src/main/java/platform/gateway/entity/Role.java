package platform.gateway.entity;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户角色
 */
@Entity
@Table(name = "roles")
@SuppressWarnings("unused")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String roleName;

    @Column
    private String userId;

    @Column
    private Bool deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userID) {
        this.userId = userID;
    }

    public Bool getDeleted() {
        return deleted;
    }

    public void setDeleted(Bool deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", userId='" + userId + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
