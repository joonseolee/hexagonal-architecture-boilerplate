package com.joonseolee.application.port.entrypoint.api;


import com.joonseolee.adaptermodel.user.SaveUserBodyDto;
import com.joonseolee.adaptermodel.user.UserDto;

public interface ChangeUserEndpointPort {

    UserDto saveUser(SaveUserBodyDto saveUserBodyDto);

    UserDto updateUser(Integer id, SaveUserBodyDto saveUserBodyDto);

    void deleteUser(Integer userId);

}
