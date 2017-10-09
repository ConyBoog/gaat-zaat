package platform.gateway.web.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import platform.gateway.entity.User;
import platform.gateway.repository.UserRepository;
import platform.gateway.web.dto.UserDTO;
import platform.gateway.web.mapper.UserMapper;


/**
 * The resource class of User.
 */
@RestController
@RequestMapping("/api")
@PreAuthorize("hasRole('ADMIN')")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUser(@RequestParam String name) {
        User user = userRepository.findByName(name);
        return new ResponseEntity<>(userMapper.userToUserDTO(user), HttpStatus.OK);
    }
}
