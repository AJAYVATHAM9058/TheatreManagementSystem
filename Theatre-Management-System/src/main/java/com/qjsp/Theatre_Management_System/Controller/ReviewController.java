package com.qjsp.Theatre_Management_System.Controller;

import java.util.List;

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

import com.qjsp.Theatre_Management_System.Service.ReviewService;
import com.qjsp.Theatre_Management_System.dto.Review;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@RestController
@RequestMapping("review/api")
public class ReviewController {

	@Autowired
	public ReviewService reviewService;
	
//	http://localhost:8080/review/api
	@PostMapping
	public ResponseStructure<Review> saveReview(@RequestBody Review review) {
	
		return reviewService.saveReview(review);
	}
	
//	http://localhost:8080/review/api/1
	@GetMapping ("{reviewId}")
	public ResponseStructure<Review> fetchReviewById(@PathVariable("reviewId") int reviewId) {
		
		return reviewService.fetchReviewById(reviewId);
	}
	
//	http://localhost:8080/review/api/8
	@DeleteMapping("{reviewId}")
	public ResponseStructure<Review> deleteReviewById(@PathVariable("reviewId") int reviewId) {
		
		return reviewService.deleteReviewById(reviewId);
	}
	
//	http://localhost:8080/review/api?reviewId=3
	@PutMapping
	public ResponseStructure<Review> updateReviewById(@RequestParam int reviewId,@RequestBody Review review) {
		return reviewService.updateReviewById(reviewId, review);
	}
	
//	http://localhost:8080/review/api
	@GetMapping
	public ResponseStructureList<Review> fetchAll() {
		return reviewService.fetchAll();
	}
	
	
}
