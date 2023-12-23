package com.example.Bookmyshow.Transformers;

import com.example.Bookmyshow.Entity.Theater;
import com.example.Bookmyshow.RequestDTO.AddTheaterRequest;

public class TheaterTransformer {
    public static Theater convertTheaterRequestToTheaterEntity(AddTheaterRequest addTheaterRequest){
        Theater theater= Theater.builder().city(addTheaterRequest.getCity()).address(addTheaterRequest.getAddress()).name(addTheaterRequest.getName()).build();
        return theater;
    }
}
