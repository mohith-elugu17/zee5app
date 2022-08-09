package com.zee.zee5app.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.repo.MovieRepository;
import com.zee.zee5app.repo.MovieRepositoryImpl;
import com.zee.zee5app.repo.UserRepo;

public class MovieServiceImpl implements MovieService {
	
	private static MovieService movieService;
	public static MovieService getInstance() {
		if(movieService == null) movieService = new MovieServiceImpl();
		return movieService;
	}

	MovieRepository movieRepo = MovieRepositoryImpl.getInstance();
	@Override
	public Movie insertMovie(Movie movie) throws IOException {
		// TODO Auto-generated method stub
		File file = new File(movie.getTrailer());
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		System.out.println(file.getName());
		 try {
			if(movie.getTrailer() == null || movie.getTrailer() == "" || !file.exists()) {
			        throw new FileNotFoundException("File does not exists");
			}
			else {
				bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
				System.out.println("file exists");
				bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D://Zee5App//trailer" + file.getName()));
				bufferedOutputStream.write(bufferedInputStream.readAllBytes());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(bufferedInputStream != null)
				bufferedInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return movieRepo.insertMovie(movie);
	}

	@Override
	public Movie updateMovie(String movieId, Movie movie) throws Exception {
		// TODO Auto-generated method stub
		return movieRepo.updateMovie(movieId, movie);
	}

	@Override
	public Optional<Movie> getMovieByMovieId(String movieId) {
		// TODO Auto-generated method stub
		return movieRepo.getMovieByMovieId(movieId);
	}

	@Override
	public Optional<Movie[]> getAllMovies() {
		// TODO Auto-generated method stub
		return movieRepo.getAllMovies();
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
	public String deleteMovieByMovieId(String movieId) throws Exception {
		// TODO Auto-generated method stub
		return movieRepo.deleteMovieByMovieId(movieId);
	}
	
	@Override
	public List<Movie> findByOrderByMovieNameDsc() {
		// TODO Auto-generated method stub
		return movieRepo.findByOrderByMovieNameDsc();
	}
}
