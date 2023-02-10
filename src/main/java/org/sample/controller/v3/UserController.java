package org.sample.controller.v3;

import org.sample.dto.UserDto;
import org.sample.exceptions.ResourceNotFoundException;
import org.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

import static org.sample.config.ConstantsApp.USER_V3;

@RestController
@RequestMapping(USER_V3)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get a user by its id, if the id equals to 0, it will return a not found response
     *
     * @param id of the user
     * @return UserDto
     * @throws ResourceNotFoundException the user was not found by its id
     *
     */
    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id){
        if(id == 0)
            throw new ResourceNotFoundException("User not found");
        else return new UserDto();
    }


    /**
     * Returns all the users stored
     *
     * @see List <UserDto>
     * @return List<UserDto> - list of users
     *
     */
    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(Collections.emptyList());
    }

    /**
     *  Creates user if the name is not empty
     *
     * @see UserDto
     * @param user with its information to be stored
     * @return UserDto - the user created
     * @return HttpStatus.BAD_REQUEST
     */
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){


        userService.example(1L);

        if(user.getName().isEmpty())
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        else return ResponseEntity.badRequest().build();
    }


    /**
     *  Updates user information with the values received
     *
     * @see UserDto
     * @param user with its information to be stored
     * @return UserDto - the user updated
     * @return HttpStatus.BAD_REQUEST
     */
    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestParam UserDto user, @RequestParam String password){
        if(password.equals("robot"))
            return ResponseEntity.ok(user);
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    /**
     * Deletes a user by its id
     *
     * @param id id of the user to be deleted
     * @return String - message of confirmation
     * @return HttpStatus.NOT_FOUND
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        if(id != 0)
            return ResponseEntity.ok("deleted user: " + id);
        else return ResponseEntity.notFound().build();
    }
}
