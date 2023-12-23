package com.example.Bookmyshow.RequestDTO;

import com.example.Bookmyshow.Enums.Genre;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddMovieRequest {

    private String movieName;
    private double rating;
    private Genre genre;
    private LocalDate releaseDate;
}
