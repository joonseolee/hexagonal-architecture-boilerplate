package com.joonseolee.application.usecase;


import com.joonseolee.domain.user.User;

import java.util.Collection;

public interface FindAllUsersUseCase {

    Collection<User> fetchAllPersisted();
}
