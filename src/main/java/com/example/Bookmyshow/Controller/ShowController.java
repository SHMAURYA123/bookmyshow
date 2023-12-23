package com.example.Bookmyshow.Controller;

import com.example.Bookmyshow.RequestDTO.AddShowRequest;
import com.example.Bookmyshow.RequestDTO.AddShowSeatRequest;
import com.example.Bookmyshow.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shows")
public class ShowController {

    @Autowired
    private ShowService showService;
    @PostMapping("/addShows")
    public ResponseEntity addShows(@RequestBody AddShowRequest addShowRequest){
        String res=showService.addShows(addShowRequest);
        return new ResponseEntity(res, HttpStatus.OK);
    }
    @PostMapping("/createShowSeat")
    public String createShowSeat(@RequestBody AddShowSeatRequest addShowSeatRequest){
      String res=showService.createShowSeat(addShowSeatRequest);
      return res;
    }
}
