package com.qjsp.Theatre_Management_System.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qjsp.Theatre_Management_System.Service.MovieService;
import com.qjsp.Theatre_Management_System.dto.Movie;
import com.qjsp.Theatre_Management_System.dto.Review;
import com.qjsp.Theatre_Management_System.dto.Screen;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@RestController
@RequestMapping("/movie/api")
public class MovieController {

	@Autowired
	public MovieService movieService;
	
//	http://localhost:8080/movie/api
	@PostMapping
	public ResponseStructure<Movie> saveMovie(@RequestBody Movie movie) {
	
		return movieService.saveMovie(movie);
	}
	
//	http://localhost:8080/movie/api/1
	@GetMapping ("{movieId}")
	public ResponseStructure<Movie> fetchMovieById(@PathVariable("movieId") int movieId) {
		
		return movieService.fetchMovieById(movieId);
	}
	
//	http://localhost:8080/movie/api/8
	@DeleteMapping("{movieId}")
	public ResponseStructure<Movie> deleteMovieById(@PathVariable("movieId") int movieId) {
		
		return movieService.deleteMovieById(movieId);
	}
	
//	http://localhost:8080/movie/api?movieId=3
	@PutMapping
	public ResponseStructure<Movie> updateMovieById(@RequestParam int movieId,@RequestBody Movie movie) {
		return movieService.updateMovieById(movieId, movie);
	}
	
//	http://localhost:8080/movie/api
	@GetMapping
	public ResponseStructureList<Movie> fetchAll() {
		return movieService.fetchAll();
	}
	

//	Adding Existing Review to movie
//	http://localhost:8080/movie/api/mapReviewToMovie/1/2
	@PutMapping("mapReviewToMovie/{reviewId}/{movieId}")
	public ResponseStructure<Movie> mapReviewToMovie(@PathVariable int reviewId, @PathVariable int movieId) {
		return movieService.mapReviewToMovie(reviewId, movieId);
	}

//	Adding New Review To Existing Movie
//	http://localhost:8080/movie/api/mapNewReviewToMovie/3
	@PutMapping("/mapNewReviewToMovie/{movieId}")
	public ResponseStructure<Movie> mapNewReviewToMovie(@RequestBody Review review, @PathVariable int movieId) {

		return movieService.mapNewReviewToMovie(review, movieId);
	}
	

	
}
