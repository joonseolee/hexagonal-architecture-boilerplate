package com.joonseolee.adaptermodel.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class SaveUserBodyDto {

    private String firstName;

    private String lastName;

    private String phone;

}
