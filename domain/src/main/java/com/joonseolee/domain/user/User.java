package com.joonseolee.domain.user;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter(AccessLevel.PACKAGE)
public class User {

    private final UserId id;

    @NotNull
    private final FullName fullName;

    @NotNull
    private final Phone phone;

}
