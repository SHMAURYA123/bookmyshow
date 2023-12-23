package com.example.Bookmyshow.RequestDTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddUserRequest {
    private String name;
    private String mobileNo;
    private Integer age;

    private String emailId;
}
