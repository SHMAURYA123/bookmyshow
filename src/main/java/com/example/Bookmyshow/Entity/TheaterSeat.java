package com.example.Bookmyshow.Entity;

import com.example.Bookmyshow.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="theaterSeats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheaterSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterSeatId;
    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn
    private Theater theater;

}
