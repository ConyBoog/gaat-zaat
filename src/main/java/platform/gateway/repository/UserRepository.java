package platform.gateway.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import platform.gateway.entity.User;

/**
 * Repository of entity User.
 */
public interface UserRepository extends CrudRepository<User, String> {

    @Query("select u from User u where u.name = ?1")
    User findByName(String name);

    @Query("select u from User u where u.login = ?1")
    User findByLogin(String login);
}
