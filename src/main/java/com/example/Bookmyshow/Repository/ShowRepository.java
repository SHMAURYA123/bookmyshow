package com.example.Bookmyshow.Repository;

import com.example.Bookmyshow.Entity.Movie;
import com.example.Bookmyshow.Entity.Show;
import com.example.Bookmyshow.Entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ShowRepository extends JpaRepository<Show,Integer> {
   Show findShowByShowDateAndShowTimeAndMovieAndTheater(LocalDate showDate, LocalTime showTime, Movie movie, Theater theater);
}
