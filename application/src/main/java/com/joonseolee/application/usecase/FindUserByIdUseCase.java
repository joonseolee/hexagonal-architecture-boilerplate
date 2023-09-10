package com.joonseolee.application.usecase;


import com.joonseolee.domain.user.User;
import com.joonseolee.domain.user.UserId;

public interface FindUserByIdUseCase {

    User findById(UserId userId);
}
