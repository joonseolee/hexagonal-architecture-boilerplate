package com.joonseolee.adaptermodel.user;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDto {

    private final String firstName;

    private final String lastName;

    private final String phone;

}
