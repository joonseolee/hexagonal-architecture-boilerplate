package com.joonseolee.adapter.persistence;


import com.joonseolee.application.port.persistence.ReadUserPort;
import com.joonseolee.domain.user.User;
import com.joonseolee.domain.user.UserId;
import com.joonseolee.infrastructure.annotations.Adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.joonseolee.domain.user.UserFunctions.userFirstName;
import static com.joonseolee.domain.user.UserFunctions.userLastName;


@Adapter
class ReadUserAdapter implements ReadUserPort {

    private final UserRepository userRepository;

    private final UserJpaMapper userJpaMapper;

    public ReadUserAdapter(UserRepository userRepository, UserJpaMapper userJpaMapper) {
        this.userRepository = userRepository;
        this.userJpaMapper = userJpaMapper;
    }

    @Override
    public Boolean existsUserByName(User user) {
        String firstName = userFirstName.apply(user);
        String lastName = userLastName.apply(user);
        return !userRepository.findByFirstNameAndLastName(firstName, lastName)
                    .isEmpty();
    }

    @Override
    public Boolean existsUserById(UserId userId) {
        Integer userIdAsInt = userId.intValue();
        return userRepository.existsById(userIdAsInt);
    }

    @Override
    public Optional<User> fetchById(UserId userId) {
        return userRepository.findById(userId.intValue())
                .map(userJpaMapper::toDomain);
    }

    @Override
    public List<User> fetchAll() {
        return userRepository.findAll()
                .stream()
                .map(userJpaMapper::toDomain)
                .toList();
    }
}
