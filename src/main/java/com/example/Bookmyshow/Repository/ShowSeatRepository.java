package com.example.Bookmyshow.Repository;

import com.example.Bookmyshow.Entity.ShowSeats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepository extends JpaRepository<ShowSeats,Integer> {

}
