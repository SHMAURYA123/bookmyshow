package com.example.Bookmyshow.Service;

import com.example.Bookmyshow.Entity.Movie;
import com.example.Bookmyshow.Repository.MovieRepository;
import com.example.Bookmyshow.RequestDTO.AddMovieRequest;
import com.example.Bookmyshow.Transformers.MovieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(AddMovieRequest addMovieRequest) {
        Movie movieObj= MovieTransformer.convertAddMovieRequestToMovie(addMovieRequest);
        movieRepository.save(movieObj);
        return"Movie added in Db successfully";
    }
}
