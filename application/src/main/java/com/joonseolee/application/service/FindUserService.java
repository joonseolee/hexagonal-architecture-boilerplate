package com.joonseolee.application.service;

import com.joonseolee.adaptermodel.persistence.exception.EntityNotFoundException;
import com.joonseolee.application.port.persistence.ReadUserPort;
import com.joonseolee.application.usecase.FindAllUsersUseCase;
import com.joonseolee.application.usecase.FindUserByIdUseCase;
import com.joonseolee.domain.user.User;
import com.joonseolee.domain.user.UserId;
import com.joonseolee.infrastructure.annotations.UseCase;
import com.joonseolee.infrastructure.validator.ObjectValidator;

import java.util.Collection;


@UseCase
class FindUserService implements FindUserByIdUseCase, FindAllUsersUseCase {

    private final ReadUserPort readUserPort;

    FindUserService(ReadUserPort readUserPort) {
        this.readUserPort = readUserPort;
    }

    @Override
    public User findById(UserId userId) {
        ObjectValidator.validate(userId);
        return readUserPort.fetchById(userId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Collection<User> fetchAllPersisted() {
        return readUserPort.fetchAll();
    }

}
