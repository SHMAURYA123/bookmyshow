package com.example.Bookmyshow.Transformers;

import com.example.Bookmyshow.Entity.Movie;
import com.example.Bookmyshow.RequestDTO.AddMovieRequest;

public class MovieTransformer {
    public static Movie convertAddMovieRequestToMovie(AddMovieRequest addMovieRequest){
        Movie movie= Movie.builder().movieName(addMovieRequest.getMovieName()).rating(addMovieRequest.getRating()).
                      genre(addMovieRequest.getGenre()).releaseDate(addMovieRequest.getReleaseDate()).build();

        return movie;
    }
}
