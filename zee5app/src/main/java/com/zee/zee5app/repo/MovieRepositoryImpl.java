package com.zee.zee5app.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.InvalidIdException;
import com.zee.zee5app.exceptions.InvalidNameException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.utils.DBUtils;

public class MovieRepositoryImpl implements MovieRepository {
	
	private List<Movie> movies = new ArrayList<>();
	
	private static MovieRepository MovieRepository;
	public static MovieRepository getInstance() {
		if(MovieRepository == null) MovieRepository = new MovieRepositoryImpl();
		return MovieRepository;
	}

	private DBUtils dbUtils = DBUtils.getInstance();
	
	@Override
	public Movie insertMovie(Movie movie) {
		// TODO Auto-generated method stub
		Connection connection = null;        
        PreparedStatement preparedStatement = null;
        String insertStatement = "insert into movie_table" 
                + "(movieid, actors, moviename, director, genre, production, language, movielength)"
                + "values(?,?,?,?,?,?,?,?)";

        connection = dbUtils.getConnection();
        try {
        	String actors = String.join(",", movie.getActors());
            String languages = String.join(",", movie.getLanguages());
            preparedStatement = connection.prepareStatement(insertStatement);
            preparedStatement.setString(1, movie.getMovieId());
            preparedStatement.setString(2, actors);
            preparedStatement.setString(3, movie.getMovieName());
            preparedStatement.setString(4, movie.getDirector());
            preparedStatement.setString(5, movie.getGenre().toString());
            preparedStatement.setString(6, movie.getProduction());
            preparedStatement.setString(7, languages);
            preparedStatement.setFloat(8, movie.getMovieLength());
            int result = preparedStatement.executeUpdate();

            if(result > 0) {
                return movie;
            }
            else {
                return null;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            dbUtils.closeConnection(connection);
        }
        return null;
	}

	@Override
	public Movie updateMovie(String movieId, Movie movie) throws InvalidIdException {
		// TODO Auto-generated method stub
		int index = this.movies.indexOf(getMovieByMovieId(movieId));
		if(index != -1) {
//			movies.add(index, movie);
			this.movies.remove(index);
			this.movies.add(movie);
			return movie;
		}
		throw new InvalidIdException("MovieId is not Valid");
	}

	@Override
	public Optional<Movie> getMovieByMovieId(String movieId) {
		// TODO Auto-generated method stub
		Connection connection = null;        
        PreparedStatement preparedStatement = null;
        String query = "select * from movie_table where movieid=?";
        ResultSet resultSet = null;
        connection = dbUtils.getConnection();
        try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, movieId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				Movie movie = new Movie();
				String[] actorsArray = resultSet.getString("actors").split(",");
				movie.setMovieId(resultSet.getString("movieid"));
				movie.setActors(actorsArray);
				movie.setMovieName(resultSet.getString("moviename"));
				movie.setDirector(resultSet.getString("director"));
				movie.setGenre(resultSet.getString("genre"));
				movie.setProduction(resultSet.getString("production"));
				String[] languageArray = resultSet.getString("language").split(",");
				movie.setLanguages(languageArray);
				movie.setMovieLength(resultSet.getFloat("movielength"));
				return Optional.of(movie);
			}
			else {
				return Optional.empty();
			}
		} catch (SQLException | InvalidIdException | InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}
        return Optional.empty();
	}

	@Override
	public Optional<Movie[]> getAllMovies() {
		// TODO Auto-generated method stub
		if(this.movies.isEmpty())
			return Optional.empty();
		Movie[] allMovies = new Movie[this.movies.size()];
		this.movies.toArray(allMovies);
		return Optional.of(allMovies);
	}

	@Override
	public Movie[] getAllMoviesByGenre(String genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie[] getAllMoviesByName(String movieName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteMovieByMovieId(String movieId) throws NoDataFoundException{
		// TODO Auto-generated method stub
		Optional<Movie> movie = this.getMovieByMovieId(movieId);
		if(movie.isPresent()) {
			int index = this.movies.indexOf(movie);
			this.movies.remove(index);
			return "Success";
		}
		throw new NoDataFoundException("MovieId not Found");
	}

	@Override
	public List<Movie> findByOrderByMovieNameDsc() {
		// TODO Auto-generated method stub
		List<Movie> dupMovies = new ArrayList(movies);
		Collections.sort(dupMovies, (e1,e2) -> e2.getMovieName().compareTo(e1.getMovieName()));
		return dupMovies;
	}

}
