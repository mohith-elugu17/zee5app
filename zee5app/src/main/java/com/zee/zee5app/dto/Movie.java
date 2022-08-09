package com.zee.zee5app.dto;

import com.zee.zee5app.enums.Languages;
import com.zee.zee5app.exceptions.InvalidIdException;
import com.zee.zee5app.exceptions.InvalidNameException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Movie {
	public void setMovieId(String movieId) throws InvalidIdException {
		int length = movieId.length();
		if(length >= 5 && length <= 7) {
			this.movieId = movieId;
		} else {
			//raise an exception
			//data is not validated
			throw new InvalidIdException("Invalid Movie ID");
		}
	}
	public void setActors(String[] actors) {
		this.actors = actors;
	}
	public void setMovieName(String movieName) throws InvalidNameException {
		if(movieName == null || movieName.length() < 3)
			throw new InvalidNameException(movieName);
		this.movieName = movieName;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setProduction(String production) {
		this.production = production;
	}
	public void setLanguages(String[] languages) {
		for (String langGiven : languages) {
			for (Languages langEnum : Languages.values()) {
				if(Languages.valueOf(langGiven).compareTo(langEnum) == 0)
					System.out.println("checked");
			}
		}
	}
	public void setMovieLength(float movieLength) {
		this.movieLength = movieLength;
	}
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	
	public Movie(String[] actors, String movieName, String director, String genre, String production,
			String[] languages, float movieLength,String trailer) throws InvalidIdException, InvalidNameException {
		super();
		this.actors = actors;
		this.setMovieName(movieName);
		this.director = director;
		this.genre = genre;
		this.production = production;
		this.languages = languages;
		this.movieLength = movieLength;
		this.trailer = trailer;
	}

	private String movieId;
    private String actors[];
    private String movieName;
    private String director;
    private String genre;
    private String production;
    private String languages[];
    private float movieLength;
    private String trailer;
}