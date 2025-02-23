package com.qjsp.Theatre_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qjsp.Theatre_Management_System.dao.MovieDao;
import com.qjsp.Theatre_Management_System.dao.ReviewDao;
import com.qjsp.Theatre_Management_System.dao.ScreenDao;
import com.qjsp.Theatre_Management_System.dto.Movie;
import com.qjsp.Theatre_Management_System.dto.Review;
import com.qjsp.Theatre_Management_System.dto.Screen;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@Service
public class MovieService {

	@Autowired
	public MovieDao movieDao;
	
	@Autowired
	public ReviewDao reviewDao;
	
	@Autowired
	public ScreenDao screenDao;
	
	@Autowired
	ResponseStructure<Movie> responseStructure;

	@Autowired
	ResponseStructureList<Movie> responseStructureList;
	
	public ResponseStructure<Movie> saveMovie(Movie movie) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Movie Data Inserted into DataBase");
		responseStructure.setData(movieDao.saveMovie(movie));
		return responseStructure;
	}
	
	public ResponseStructure<Movie> fetchMovieById(int movieId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Movie Data Retrieved from DataBase");
		responseStructure.setData(movieDao.fetchMovieById(movieId));
		return responseStructure;
	}
	
	public ResponseStructure<Movie> deleteMovieById(int movieId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Movie Data Deleted From DataBase");
		responseStructure.setData(movieDao.deleteMovieById(movieId));
		return responseStructure;
	}
	
	public ResponseStructure<Movie> updateMovieById(int movieId,Movie movie) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Movie Data Updated From DataBase");
		responseStructure.setData(movieDao.updateMovieById(movieId, movie));
		return responseStructure;
	}
	
	public ResponseStructureList<Movie> fetchAll() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("Successfully fetched all the Movies from Database");
		responseStructureList.setData(movieDao.fetchAll());

		return responseStructureList;
	}
	
	

//	Adding existing Review to Existing Movie
	public ResponseStructure<Movie> mapReviewToMovie(int reviewId, int movieId) {

		Review review = reviewDao.fetchReviewById(reviewId);
		Movie movie = movieDao.fetchMovieById(movieId);
		List<Review> list = movie.getReview();
		list.add(review);
		movie.setReview(list);

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Added Existing Review to Movie ");
		responseStructure.setData(movieDao.saveMovie(movie));
		return responseStructure;

	}

	
//	Adding New Review to existing movie
	public ResponseStructure<Movie> mapNewReviewToMovie(Review review, int movieId) {
		Movie movie = movieDao.fetchMovieById(movieId);
		List<Review> list = movie.getReview();
		list.add(review);
		movie.setReview(list);

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Added New Review to Movie ");
		responseStructure.setData(movieDao.saveMovie(movie));
		return responseStructure;

	}


	
	
	
}
