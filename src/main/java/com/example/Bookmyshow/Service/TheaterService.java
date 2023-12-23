package com.example.Bookmyshow.Service;

import com.example.Bookmyshow.Entity.Theater;
import com.example.Bookmyshow.Entity.TheaterSeat;
import com.example.Bookmyshow.Enums.SeatType;
import com.example.Bookmyshow.Repository.TheaterRepository;
import com.example.Bookmyshow.RequestDTO.AddTheaterRequest;
import com.example.Bookmyshow.Transformers.TheaterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;
    public String addTheater(AddTheaterRequest addTheaterRequest) {
           Theater theater= TheaterTransformer.convertTheaterRequestToTheaterEntity(addTheaterRequest);

           //create theater seats
          createTheaterSeats(theater,addTheaterRequest);
          return "Theater and its seat have been saved in DB";
    }

    public void createTheaterSeats(Theater theater,AddTheaterRequest addTheaterRequest){
        int noOfClassicSeats=addTheaterRequest.getNoOfClassicSeats();
        int noOfPremiumSeats=addTheaterRequest.getNoOfPremiumSeats();
        int noOfSeatsPerRow=addTheaterRequest.getNoOfSeatsPerRow();

        List<TheaterSeat> theaterSeatList=new ArrayList<>();

        int row=0;
        char ch='A';
        for(int i=1;i<=noOfClassicSeats;i++){
            if(i%noOfSeatsPerRow==1){
               row++;
               ch='A';
            }

            String seatNo=row+""+ch;
            ch++;

           TheaterSeat theaterSeat=TheaterSeat.builder().seatNo(seatNo).seatType(SeatType.CLASSIC).theater(theater).build();
           theaterSeatList.add(theaterSeat);
        }


         ch='A';
        for(int i=1;i<=noOfPremiumSeats;i++){
            if(i%noOfSeatsPerRow==1){
                row++;
                ch='A';
            }

            String seatNo=row+""+ch;
            ch++;

            TheaterSeat theaterSeat=TheaterSeat.builder().seatNo(seatNo).seatType(SeatType.PREMIUM).theater(theater).build();
            theaterSeatList.add(theaterSeat);
        }

        theater.setTheaterSeatList(theaterSeatList);
        theaterRepository.save(theater);
    }
}
