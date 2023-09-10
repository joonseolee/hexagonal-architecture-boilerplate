package com.joonseolee.application.port.persistence;


import com.joonseolee.domain.user.User;
import com.joonseolee.domain.user.UserId;

import java.util.List;
import java.util.Optional;

public interface ReadUserPort {

    Boolean existsUserByName(User user);

    Boolean existsUserById(UserId userId);

    Optional<User> fetchById(UserId userId);

    List<User> fetchAll();
}
