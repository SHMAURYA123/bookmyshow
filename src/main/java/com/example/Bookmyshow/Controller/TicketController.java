package com.example.Bookmyshow.Controller;

import com.example.Bookmyshow.RequestDTO.BookTicketRequest;
import com.example.Bookmyshow.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;
@PostMapping("/bookTicket")
    public String bookTicket(@RequestBody BookTicketRequest bookTicketRequest){
        String res=ticketService.bookTicket(bookTicketRequest);
        return res;
    }
}
