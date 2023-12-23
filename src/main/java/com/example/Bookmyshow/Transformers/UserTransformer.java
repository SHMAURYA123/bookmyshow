package com.example.Bookmyshow.Transformers;

import com.example.Bookmyshow.Entity.User;
import com.example.Bookmyshow.RequestDTO.AddUserRequest;

public class UserTransformer {

    public static User convertUserRequesttoUserEntity(AddUserRequest addUserRequest){
        User userObj= User.builder().age(addUserRequest.getAge()).name(addUserRequest.getName()).emailId(addUserRequest.getEmailId()).mobileNo(addUserRequest.getMobileNo()).build();
        return userObj;
    }
}
