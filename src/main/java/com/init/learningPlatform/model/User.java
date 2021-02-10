package com.init.learningPlatform.model;

import com.init.learningPlatform.helper.GenderEnum;
import com.init.learningPlatform.helper.UserTypeEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_init_1")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String username;
    @Column(name = "password", nullable = false, unique = false, length = 50)
    private String password;
    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;
    @Column(name = "phoneNumber", nullable = false, unique = true, length = 50)
    private String phoneNumber;
    @Column(name = "gender", nullable = false, unique = false, length = 50)
    private GenderEnum gender;
    @Column(name = "userType", nullable = false, length = 50)
    private UserTypeEnum userType;
    @Column(name = "isActive", nullable = false, unique = false, length = 50)
    private int isActive;

    private User(){
        this.isActive = 1;
    }
    public static class Builder{
        private String username;
        private String email;
        private String password;
        private GenderEnum gender;
        private int isActive;
        private String phoneNumber;
        private UserTypeEnum userTypeEnum;
        public Builder(String username){
            this.username = username;
            this.isActive = 1;
        }

        public Builder withEmail(String email){
            this.email = email;
            return this;
        }
        public Builder withUserType(UserTypeEnum userType){
            this.userTypeEnum = userType;
            return this;
        }
        public Builder withPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Builder withPassword(String password){
            this.password = password;
            return this;
        }

        public Builder withGender(GenderEnum gender){
            this.gender = gender;
            return this;
        }

        public Builder isActive(int isActive){
            this.isActive = isActive;
            return this;
        }

        public User build(){
            User user1 = new User();
            user1.username = this.username;
            user1.email = this.email;
            user1.userType = this.userTypeEnum;
            user1.password = this.password;
            user1.gender = this.gender;
            user1.isActive = this.isActive;
            user1.phoneNumber = this.phoneNumber;
            return user1;
        }

    }

}
