package com.example.Bookmyshow.Service;

import com.example.Bookmyshow.Entity.*;
import com.example.Bookmyshow.Repository.*;
import com.example.Bookmyshow.RequestDTO.BookTicketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TheaterRepository theaterRepository;
    public String bookTicket(BookTicketRequest bookTicketRequest) {
     Show show=FindByRightShow(bookTicketRequest);
        List<ShowSeats> showSeatsList=show.getShowSeatsList();

        int totalPrice=0;
        for(ShowSeats showSeats:showSeatsList){

            if(bookTicketRequest.getRequestedSeatNos().contains(showSeats.getSeatNo())){
                showSeats.setIsAvailable(false);
                totalPrice=totalPrice+showSeats.getCost();
            }
        }

        User user =userRepository.findById(bookTicketRequest.getUserId()).get();
        Ticket ticket= Ticket.builder().movieName(show.getMovie().getMovieName()).theaterAddress(show.getTheater().getAddress()).
                showDate(show.getShowDate()).showTime(show.getShowTime()).bookedSeats(bookTicketRequest.getRequestedSeatNos().toString()).
                user(user).show(show).totalPrice(totalPrice).build();

        show.getTicketList().add(ticket);
        user.getTicketList().add(ticket);

        ticketRepository.save(ticket);

        return "Ticket has been booked";
    }

    private Show FindByRightShow(BookTicketRequest bookTicketRequest) {
        Movie movie= movieRepository.findMovieByMovieName(bookTicketRequest.getMovieName());
        Theater theater=theaterRepository.findById(bookTicketRequest.getTheaterId()).get();
        Show show1=showRepository.findShowByShowDateAndShowTimeAndMovieAndTheater(bookTicketRequest.getShowDate(),bookTicketRequest.getShowTime(),movie,theater);
        return show1;
    }
}
