package com.example.Bookmyshow.RequestDTO;

import com.example.Bookmyshow.Enums.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddTheaterRequest {

    private String name;
    private String address;
    private City city;
    private Integer noOfClassicSeats;
    private Integer noOfPremiumSeats;
    private Integer noOfSeatsPerRow;
    
}
