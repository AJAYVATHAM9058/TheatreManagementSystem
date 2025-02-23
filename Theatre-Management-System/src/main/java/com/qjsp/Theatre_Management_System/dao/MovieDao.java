package com.qjsp.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qjsp.Theatre_Management_System.Exception.MovieIdNotFound;
import com.qjsp.Theatre_Management_System.Repo.MovieRepository;
import com.qjsp.Theatre_Management_System.dto.Movie;

@Repository
public class MovieDao {

	@Autowired
	public MovieRepository movieRepository;
	
	public Movie saveMovie(Movie movie) {
		return movieRepository.save(movie);
	}
	
	public Movie fetchMovieById(int movieId) {
		Optional<Movie> optional = movieRepository.findById(movieId);
		if(optional.isEmpty()) {
			throw new MovieIdNotFound("No Movie present with the given Id "+movieId);
		}
		else {
			
			return movieRepository.findById(movieId).get();
		}
	}

	public Movie deleteMovieById(int movieId) {
		Movie movie = fetchMovieById(movieId);
		movieRepository.delete(movie);
		return movie;

	}

	public Movie updateMovieById(int movieId, Movie movie) {
		fetchMovieById(movieId);
		movie.setMovieId(movieId);
		return saveMovie(movie);

	}
	
	public List<Movie> fetchAll(){
		return movieRepository.findAll();
	}
	
}
