package com.joonseolee.adapter.api;


import com.joonseolee.adaptermodel.user.SaveUserBodyDto;
import com.joonseolee.adaptermodel.user.UserDto;
import com.joonseolee.application.port.entrypoint.api.ChangeUserEndpointPort;
import com.joonseolee.application.usecase.ChangeExistingUserUseCase;
import com.joonseolee.application.usecase.DeleteUsersByIdUseCase;
import com.joonseolee.application.usecase.SubmitNewUserUseCase;
import com.joonseolee.domain.user.User;
import com.joonseolee.domain.user.UserId;
import com.joonseolee.infrastructure.annotations.Adapter;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
class ChangeUserEndpointAdapter implements ChangeUserEndpointPort {

    private final SubmitNewUserUseCase submitNewUserUseCase;

    private final ChangeExistingUserUseCase changeExistingUserUseCase;

    private final DeleteUsersByIdUseCase deleteUsersByIdUseCase;

    private final UserDtoMapper userDtoMapper;

    @Override
    public UserDto saveUser(SaveUserBodyDto saveUserBodyDto) {
        User user = userDtoMapper.toDomainFromSaveBody(saveUserBodyDto);
        User savedUser = submitNewUserUseCase.saveUser(user);
        return userDtoMapper.toDto(savedUser);
    }

    @Override
    public UserDto updateUser(Integer id, SaveUserBodyDto saveUserBodyDto) {
        User user = userDtoMapper.toDomainFromSaveBody(id, saveUserBodyDto);
        User updatedUser = changeExistingUserUseCase.updateUser(user);
        return userDtoMapper.toDto(updatedUser);
    }

    @Override
    public void deleteUser(Integer id) {
        UserId userId = UserId.of(id);
        deleteUsersByIdUseCase.deleteById(userId);
    }

}
