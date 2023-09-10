package com.joonseolee.application.usecase;


import com.joonseolee.domain.user.UserId;

public interface DeleteUsersByIdUseCase {

    void deleteById(UserId userId);

}
