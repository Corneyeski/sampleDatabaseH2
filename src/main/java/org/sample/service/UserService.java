package org.sample.service;

import org.sample.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    int createUser(UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto findUserById(int id);

}
