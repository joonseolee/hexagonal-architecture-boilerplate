package com.joonseolee.application.usecase;


import com.joonseolee.domain.user.User;

public interface SubmitNewUserUseCase {

    User saveUser(User user);
}
