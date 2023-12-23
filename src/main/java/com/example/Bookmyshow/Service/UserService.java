package com.example.Bookmyshow.Service;

import com.example.Bookmyshow.Entity.User;
import com.example.Bookmyshow.Repository.UserRepository;
import com.example.Bookmyshow.RequestDTO.AddUserRequest;
import com.example.Bookmyshow.Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public String addUser(AddUserRequest addUserRequest) {
        User userobj= UserTransformer.convertUserRequesttoUserEntity(addUserRequest);
        userRepository.save(userobj);

        return "User added Successfully";
    }
}
