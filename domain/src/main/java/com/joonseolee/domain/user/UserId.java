package com.joonseolee.domain.user;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;

@Getter(AccessLevel.PACKAGE)
@Value(staticConstructor = "of")
public class UserId {

    @NotNull
    Integer intValue;

    public Integer intValue() {
        return intValue;
    }
}
