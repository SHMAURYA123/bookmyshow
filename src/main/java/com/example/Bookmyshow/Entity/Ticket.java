package com.example.Bookmyshow.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name="tickets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    private String movieName;
    private Integer totalPrice;
    private String bookedSeats;
    private LocalDate showDate;

    private LocalTime showTime;
    private String theaterAddress;

    @ManyToOne
    @JoinColumn
    private Show show;

    @ManyToOne
    @JoinColumn
    private User user;
}
