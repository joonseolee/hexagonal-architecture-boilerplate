package com.joonseolee.adapter.persistence;


import com.joonseolee.adapter.persistence.model.UserEntity;
import com.joonseolee.domain.user.FullName;
import com.joonseolee.domain.user.Phone;
import com.joonseolee.domain.user.User;
import com.joonseolee.domain.user.UserId;
import com.joonseolee.infrastructure.annotations.Mapper;

import java.time.LocalDateTime;

import static com.joonseolee.domain.user.UserFunctions.*;


@Mapper
class UserJpaMapper {

    UserJpaMapper() {
        super();
    }

    UserEntity toJpaEntity(User user) {
        return UserEntity.builder()
                .id(userIdAsInt.apply(user))
                .firstName(userFirstName.apply(user))
                .lastName(userLastName.apply(user))
                .phone(userPhoneNumber.apply(user))
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    UserEntity toJpaEntity(User user, UserEntity persistedUserData) {
        return persistedUserData.toBuilder()
                .firstName(userFirstName.apply(user))
                .lastName(userLastName.apply(user))
                .phone(userPhoneNumber.apply(user))
                .updatedAt(LocalDateTime.now())
                .build();
    }

    User toDomain(UserEntity userData) {
        return User.builder()
                .id(UserId.of(userData.getId()))
                .fullName(FullName.of(userData.getFirstName(), null, userData.getLastName()))
                .phone(Phone.of(userData.getPhone()))
                .build();
    }

}
