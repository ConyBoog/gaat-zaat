package platform.gateway.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import platform.gateway.entity.UserItem;

import java.util.List;

/**
 * DAO of UserItem.
 */
public interface UserItemRepository extends CrudRepository<UserItem, Long> {

    @Query("select u from UserItem u where u.user.id = ?1 and deleted = false")
    List<UserItem> findByUserId(String userId);
}
