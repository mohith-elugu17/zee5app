package com.zee.zee5app.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;

public interface MovieService {
	public Movie insertMovie(Movie movie) throws FileNotFoundException, IOException;
    public Movie updateMovie(String movieId, Movie movie) throws Exception;
    public Optional<Movie> getMovieByMovieId(String movieId);
    public Optional<Movie[]> getAllMovies();
    public Movie[] getAllMoviesByGenre(String genre);
    public Movie[] getAllMoviesByName(String movieName);
    public String deleteMovieByMovieId(String movieId) throws Exception;
	List<Movie> findByOrderByMovieNameDsc();
}
