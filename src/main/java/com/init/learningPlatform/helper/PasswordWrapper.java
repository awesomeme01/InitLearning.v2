package com.init.learningPlatform.helper;

import com.init.learningPlatform.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PasswordWrapper {
    private User user;
    private String newPassword;

}
