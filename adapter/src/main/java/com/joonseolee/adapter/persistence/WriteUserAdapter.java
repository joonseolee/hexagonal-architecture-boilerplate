package com.joonseolee.adapter.persistence;


import com.joonseolee.adapter.persistence.model.UserEntity;
import com.joonseolee.application.port.persistence.WriteUserPort;
import com.joonseolee.domain.user.User;
import com.joonseolee.domain.user.UserId;
import com.joonseolee.infrastructure.annotations.Adapter;

import java.util.Optional;

import static com.joonseolee.domain.user.UserFunctions.userIdAsInt;


@Adapter
class WriteUserAdapter implements WriteUserPort {

    private final UserRepository userRepository;

    private final UserJpaMapper userJpaMapper;

    public WriteUserAdapter(UserRepository userRepository, UserJpaMapper userJpaMapper) {
        this.userRepository = userRepository;
        this.userJpaMapper = userJpaMapper;
    }

    @Override
    public User saveNew(User user) {
        UserEntity userEntity = userJpaMapper.toJpaEntity(user);
        UserEntity userSaved = userRepository.save(userEntity);
        return userJpaMapper.toDomain(userSaved);
    }

    @Override
    public Optional<User> update(User user) {
        int userId = userIdAsInt.apply(user);
        return userRepository.findById(userId)
                .map(persistedUserData -> userJpaMapper.toJpaEntity(user, persistedUserData))
                .map(userRepository::save)
                .map(userJpaMapper::toDomain);
    }

    @Override
    public void deleteById(UserId userId) {
        userRepository.deleteById(userId.intValue());
    }


}
