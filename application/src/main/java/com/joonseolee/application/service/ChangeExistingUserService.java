package com.joonseolee.application.service;

import com.joonseolee.adaptermodel.persistence.exception.EntityNotFoundException;
import com.joonseolee.application.port.persistence.WriteUserPort;
import com.joonseolee.application.usecase.ChangeExistingUserUseCase;
import com.joonseolee.domain.user.User;
import com.joonseolee.infrastructure.annotations.UseCase;
import com.joonseolee.infrastructure.validator.ObjectValidator;


@UseCase
class ChangeExistingUserService implements ChangeExistingUserUseCase {

    private final WriteUserPort writeUserPort;

    public ChangeExistingUserService(WriteUserPort writeUserPort) {
        this.writeUserPort = writeUserPort;
    }

    @Override
    public User updateUser(User user) {
        ObjectValidator.validate(user);

        return writeUserPort.update(user).orElseThrow(EntityNotFoundException::new);
    }
}
