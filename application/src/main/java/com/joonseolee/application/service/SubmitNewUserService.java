package com.joonseolee.application.service;

import com.joonseolee.application.port.persistence.ReadUserPort;
import com.joonseolee.application.port.persistence.WriteUserPort;
import com.joonseolee.application.usecase.SubmitNewUserUseCase;
import com.joonseolee.domain.user.User;
import com.joonseolee.infrastructure.annotations.UseCase;
import com.joonseolee.infrastructure.validator.ObjectValidator;
import org.springframework.stereotype.Service;

@UseCase
class SubmitNewUserService implements SubmitNewUserUseCase {

    private final WriteUserPort writeUserPort;

    private final ReadUserPort readUserPort;

    SubmitNewUserService(WriteUserPort writeUserPort,
                         ReadUserPort readUserPort) {
        this.writeUserPort = writeUserPort;
        this.readUserPort = readUserPort;
    }

    @Override
    public User saveUser(User user) {
        ObjectValidator.validate(user);

        if(readUserPort.existsUserByName(user)) {
            throw new IllegalArgumentException("User duplicated...");
        }
        return writeUserPort.saveNew(user);
    }
}
