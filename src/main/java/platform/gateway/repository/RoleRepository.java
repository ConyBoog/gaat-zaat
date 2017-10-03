package platform.gateway.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import platform.gateway.entity.Role;

import java.util.List;

/**
 * DAO of Role entity.
 */
public interface RoleRepository  extends CrudRepository<Role, Long> {

    @Query("select r from Role r where r.userId = ?1")
    List<Role> findByUserId(String userId);
}
