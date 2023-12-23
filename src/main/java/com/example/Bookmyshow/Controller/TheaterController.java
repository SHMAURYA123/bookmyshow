package com.example.Bookmyshow.Controller;

import com.example.Bookmyshow.Entity.Theater;
import com.example.Bookmyshow.RequestDTO.AddTheaterRequest;
import com.example.Bookmyshow.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theaters")
public class TheaterController {
    @Autowired
    private TheaterService theaterService;
    @PostMapping("/addTheater")
    public ResponseEntity addTheater(@RequestBody AddTheaterRequest addTheaterRequest){
        String res=theaterService.addTheater(addTheaterRequest);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
