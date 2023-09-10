package com.joonseolee.adapter.api;


import com.joonseolee.adaptermodel.user.SaveUserBodyDto;
import com.joonseolee.adaptermodel.user.UserDto;
import com.joonseolee.domain.user.FullName;
import com.joonseolee.domain.user.Phone;
import com.joonseolee.domain.user.User;
import com.joonseolee.domain.user.UserId;
import com.joonseolee.infrastructure.annotations.Mapper;

import static com.joonseolee.domain.user.UserFunctions.userFirstName;
import static com.joonseolee.domain.user.UserFunctions.userLastName;
import static com.joonseolee.domain.user.UserFunctions.userPhoneNumber;

@Mapper
class UserDtoMapper {

    UserDtoMapper() {
        super();
    }

    UserDto toDto(User user) {
        return UserDto.builder()
                .firstName(userFirstName.apply(user))
                .lastName(userLastName.apply(user))
                .phone(userPhoneNumber.apply(user))
                .build();
    }

    User toDomainFromSaveBody(SaveUserBodyDto saveUserBodyDto) {
        return User.builder()
                .fullName(FullName.of(saveUserBodyDto.getFirstName(), null, saveUserBodyDto.getLastName()))
                .phone(Phone.of(saveUserBodyDto.getPhone()))
                .build();
    }

    User toDomainFromSaveBody(Integer userId, SaveUserBodyDto saveUserBodyDto) {
        return User.builder()
                .id(UserId.of(userId))
                .fullName(FullName.of(saveUserBodyDto.getFirstName(), null, saveUserBodyDto.getLastName()))
                .phone(Phone.of(saveUserBodyDto.getPhone()))
                .build();
    }
}
