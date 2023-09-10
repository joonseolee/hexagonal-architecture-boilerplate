package com.joonseolee.application.port.entrypoint.api;


import com.joonseolee.adaptermodel.user.UserDto;

import java.util.Collection;

public interface FindUserEndpointPort {

    Collection<UserDto> fetchAllUsers();

    UserDto fetchUserById(Integer userId);
}
