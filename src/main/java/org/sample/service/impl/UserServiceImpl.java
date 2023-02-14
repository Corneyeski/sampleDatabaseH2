package org.sample.service.impl;

import org.sample.dto.UserDto;
import org.sample.entities.User;
import org.sample.repository.UserRepository;
import org.sample.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public int createUser(UserDto userDto) {

        User user = new User(
                userDto.getName(),
                userDto.getLastname(),
                userDto.getPassword()
        );

        user = userRepository.createUser(user);

        return user.getId();
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<UserDto> userDtos = new ArrayList<>();

        userRepository.findAll().forEach(
                user -> {
                    userDtos.add(new UserDto(
                            user.getId(),
                            user.getName(),
                            user.getLastname(),
                            user.getPassword()
                    ));
                }
        );

        return userDtos;
    }

    @Override
    public UserDto findUserById(int id) {

        UserDto userDto = new UserDto();
        User user = userRepository.findById(id);

        BeanUtils.copyProperties(user, userDto);

        return userDto;
    }
}
