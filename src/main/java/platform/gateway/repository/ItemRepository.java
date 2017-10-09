package platform.gateway.repository;

import org.springframework.data.repository.CrudRepository;
import platform.gateway.entity.Item;

/**
 * DAO of Item.
 */
public interface ItemRepository extends CrudRepository<Item, String> {


}
