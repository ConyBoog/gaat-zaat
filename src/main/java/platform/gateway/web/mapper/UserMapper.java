package platform.gateway.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import platform.gateway.entity.User;
import platform.gateway.web.dto.UserDTO;

import java.util.List;

/**
 * The mapper of entity User and UserDTO.
 */
@Mapper(componentModel = "spring")
@SuppressWarnings("unused")
public interface UserMapper {

    User userDTOToUser(UserDTO userDTO);

    List<User> userDTOsToUsers(List<UserDTO> userDTOs);

    @Mapping(target = "password",ignore = true)
    UserDTO userToUserDTO(User user);

    List<UserDTO> usersToUserDTOs(List<User> users);
}
