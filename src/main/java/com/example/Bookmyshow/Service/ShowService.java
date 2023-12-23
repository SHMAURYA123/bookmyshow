package com.example.Bookmyshow.Service;

import com.example.Bookmyshow.Entity.*;
import com.example.Bookmyshow.Enums.SeatType;
import com.example.Bookmyshow.Repository.MovieRepository;
import com.example.Bookmyshow.Repository.ShowRepository;
import com.example.Bookmyshow.Repository.ShowSeatRepository;
import com.example.Bookmyshow.Repository.TheaterRepository;
import com.example.Bookmyshow.RequestDTO.AddShowRequest;
import com.example.Bookmyshow.RequestDTO.AddShowSeatRequest;
import com.example.Bookmyshow.Transformers.ShowTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {


    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private TheaterRepository theaterRepository;
   @Autowired
   private MovieRepository movieRepository;

   @Autowired
  private ShowSeatRepository showSeatRepository;
    public String addShows(AddShowRequest addShowRequest) {
        Show show= ShowTransformer.convertAddShowRequestToShow(addShowRequest);
        Movie movie=movieRepository.findMovieByMovieName(addShowRequest.getMovieName());
        Optional<Theater>optionalTheater=theaterRepository.findById(addShowRequest.getTheaterId());
        Theater theater=optionalTheater.get();

        //set fk entity
        show.setMovie(movie);
        show.setTheater(theater);

        //setting the bidirectional mapping
        theater.getShowList().add(show);
        movie.getShowList().add(show);

        show=showRepository.save(show);
        return "Show has been saved to the db with showId"+show.getShowId();
    }

    public String createShowSeat(AddShowSeatRequest addShowSeatRequest) {
        Show show=showRepository.findById(addShowSeatRequest.getShowId()).get();
        Theater theater=show.getTheater();
        List<TheaterSeat> theaterSeatList=theater.getTheaterSeatList();

        List<ShowSeats> showSeatsList=new ArrayList<>();

        for(TheaterSeat theaterSeat:theaterSeatList){
            ShowSeats showSeats= ShowSeats.builder().seatNo(theaterSeat.getSeatNo()).seatType(theaterSeat.getSeatType()).
                    isAvailable(true).isFoodAttached(false).show(show).build();

            if(theaterSeat.getSeatType().equals(SeatType.CLASSIC)){
                showSeats.setCost(addShowSeatRequest.getPriceOfClassicSeat());
            }else{
                showSeats.setCost(addShowSeatRequest.getPriceofPremimSeat());
            }
            showSeatsList.add(showSeats);
        }

        show.setShowSeatsList(showSeatsList);
        showRepository.save(show);
        return "The show seats have been added";
    }
}
