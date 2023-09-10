package com.joonseolee.adapter.api;


import com.joonseolee.adaptermodel.user.UserDto;
import com.joonseolee.application.port.entrypoint.api.FindUserEndpointPort;
import com.joonseolee.application.usecase.FindAllUsersUseCase;
import com.joonseolee.application.usecase.FindUserByIdUseCase;
import com.joonseolee.domain.user.User;
import com.joonseolee.domain.user.UserId;
import com.joonseolee.infrastructure.annotations.Adapter;

import java.util.Collection;

@Adapter
class FindUserEndpointAdapter implements FindUserEndpointPort {

    private final FindAllUsersUseCase findAllUsersUseCase;

    private final FindUserByIdUseCase findUserByIdUseCase;

    private final UserDtoMapper userDtoMapper;

    FindUserEndpointAdapter(FindAllUsersUseCase findAllUsersUseCase,
                            FindUserByIdUseCase findUserByIdUseCase,
                            UserDtoMapper userDtoMapper) {
        this.findAllUsersUseCase = findAllUsersUseCase;
        this.findUserByIdUseCase = findUserByIdUseCase;
        this.userDtoMapper = userDtoMapper;
    }

    @Override
    public UserDto fetchUserById(Integer id) {
        UserId userId = UserId.of(id);
        User foundUser = findUserByIdUseCase.findById(userId);
        return userDtoMapper.toDto(foundUser);
    }

    @Override
    public Collection<UserDto> fetchAllUsers() {
        return findAllUsersUseCase.fetchAllPersisted()
                .stream()
                .map(userDtoMapper::toDto)
                .toList();
    }
}
