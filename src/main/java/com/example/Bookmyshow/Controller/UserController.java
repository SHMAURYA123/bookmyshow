package com.example.Bookmyshow.Controller;

import com.example.Bookmyshow.Entity.User;
import com.example.Bookmyshow.RequestDTO.AddUserRequest;
import com.example.Bookmyshow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
   @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody AddUserRequest addUserRequest){
     String res=userService.addUser(addUserRequest);
     return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
