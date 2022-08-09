package com.zee.zee5app.repo;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;

public interface MovieRepository {
	public Movie insertMovie(Movie movie);
    public Movie updateMovie(String movieId, Movie movie) throws Exception;
    public Optional<Movie> getMovieByMovieId(String movieId);
    public Optional<Movie[]> getAllMovies();
    public Movie[] getAllMoviesByGenre(String genre);
    public Movie[] getAllMoviesByName(String movieName);
    public String deleteMovieByMovieId(String movieId) throws Exception;
    public List<Movie> findByOrderByMovieNameDsc();
}
