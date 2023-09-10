package com.joonseolee.application.service;

import com.joonseolee.application.port.persistence.ReadUserPort;
import com.joonseolee.application.port.persistence.WriteUserPort;
import com.joonseolee.application.usecase.DeleteUsersByIdUseCase;
import com.joonseolee.domain.user.UserId;
import com.joonseolee.infrastructure.annotations.UseCase;
import com.joonseolee.infrastructure.validator.ObjectValidator;
import org.springframework.stereotype.Service;

@UseCase
class DeleteUsersByIdService implements DeleteUsersByIdUseCase {

    private final WriteUserPort writeUserPort;

    private final ReadUserPort readUserPort;

    DeleteUsersByIdService(WriteUserPort writeUserPort,
                           ReadUserPort readUserPort) {
        this.writeUserPort = writeUserPort;
        this.readUserPort = readUserPort;
    }

    @Override
    public void deleteById(UserId userId) {
        ObjectValidator.validate(userId);

        if (!readUserPort.existsUserById(userId)) {
            throw new IllegalArgumentException("User missed on the repository, not able to delete it...");
        }

        writeUserPort.deleteById(userId);
    }
}
