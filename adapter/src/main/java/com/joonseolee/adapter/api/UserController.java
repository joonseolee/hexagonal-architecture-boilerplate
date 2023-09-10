package com.joonseolee.adapter.api;


import com.joonseolee.adaptermodel.user.SaveUserBodyDto;
import com.joonseolee.adaptermodel.user.UserDto;
import com.joonseolee.application.port.entrypoint.api.ChangeUserEndpointPort;
import com.joonseolee.application.port.entrypoint.api.FindUserEndpointPort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
class UserController {

    private final ChangeUserEndpointPort changeUserEndpointAdapter;

    private final FindUserEndpointPort findUserEndpointAdapter;

    UserController(ChangeUserEndpointAdapter changeUserEndpointAdapter,
                   FindUserEndpointAdapter findUserEndpointAdapter) {
        this.changeUserEndpointAdapter = changeUserEndpointAdapter;
        this.findUserEndpointAdapter = findUserEndpointAdapter;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto saveUser(@RequestBody @Valid SaveUserBodyDto saveUserBodyDto) {
        return changeUserEndpointAdapter.saveUser(saveUserBodyDto);
    }

    @PutMapping("/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto updateUser(@PathVariable("user_id") int userId,
                              @RequestBody @Valid SaveUserBodyDto saveUserBodyDto) {
        return changeUserEndpointAdapter.updateUser(userId, saveUserBodyDto);
    }

    @GetMapping("/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto fetchUserById(@PathVariable("user_id") Integer userId) {
        return findUserEndpointAdapter.fetchUserById(userId);
    }

    @DeleteMapping("/{user_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable("user_id") Integer userId) {
        changeUserEndpointAdapter.deleteUser(userId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<UserDto> fetchAllUsers() {
        return findUserEndpointAdapter.fetchAllUsers();
    }

}
