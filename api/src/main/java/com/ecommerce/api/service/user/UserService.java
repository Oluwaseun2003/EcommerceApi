package com.ecommerce.api.service.user;

import com.ecommerce.api.dto.UserDto;
import com.ecommerce.api.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(UserDto userDto);

    User getUser(Long id);

    List<User> getAllUsers();
    User updateUser(UserDto userDto, Long id);

    User deleteUser(Long id);
}
