package com.example.Bookmyshow.Repository;

import com.example.Bookmyshow.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
  Movie findMovieByMovieName(String movieName);
}
