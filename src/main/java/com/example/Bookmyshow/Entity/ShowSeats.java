package com.example.Bookmyshow.Entity;

import com.example.Bookmyshow.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="show_seats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ShowSeats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;

    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private Integer Cost;
    private Boolean isAvailable;
    private Boolean isFoodAttached;

    @ManyToOne
    @JoinColumn
    private Show show;
}
