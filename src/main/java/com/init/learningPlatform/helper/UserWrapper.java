package com.init.learningPlatform.helper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserWrapper {
    private String username;
    private String email;
    private String password;
    private GenderEnum gender;
    private int isActive;
    private Long phoneNumber;

}
