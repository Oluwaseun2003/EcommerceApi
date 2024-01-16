package com.ecommerce.api.service.user;

import com.ecommerce.api.dto.UserDto;
import com.ecommerce.api.entities.User;
import com.ecommerce.api.exceptions.UserAlreadyExist;
import com.ecommerce.api.exceptions.UserException;
import com.ecommerce.api.repositories.UserRepo;
import com.ecommerce.api.utilities.PasswordUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;

    @Override
    public User createUser(UserDto userDto) {
        Optional<User> user = userRepo.findByEmail(userDto.getEmail());
        if(user.isPresent()){
            throw new UserAlreadyExist("User already exists");
        }
        User userInfo = User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .phoneNumber(userDto.getPhoneNumber())
                .password(PasswordUtil.hashPassword(userDto.getPassword()))
                .build();
        return userRepo.save(userInfo);
    }

    @Override
    public User getUser(Long id) {
        return userRepo.findById(id).orElseThrow(()-> new UserException("User can not be found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User updateUser(UserDto userDto, Long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new UserException("User not found"));

        User userInfo = User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .phoneNumber(userDto.getPhoneNumber())
                .password(PasswordUtil.hashPassword(userDto.getPassword()))
                .build();
        return userRepo.save(userInfo);


    }

    @Override
    public User deleteUser(Long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new UserException("User not found"));
        userRepo.delete(user);
        return user;
    }
}
