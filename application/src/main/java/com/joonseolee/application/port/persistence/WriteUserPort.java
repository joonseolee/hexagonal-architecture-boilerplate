package com.joonseolee.application.port.persistence;


import com.joonseolee.domain.user.User;
import com.joonseolee.domain.user.UserId;

import java.util.Optional;

public interface WriteUserPort {

    User saveNew(User user);

    Optional<User> update(User user);

    void deleteById(UserId userId);
}
