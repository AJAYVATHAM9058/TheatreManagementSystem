package com.qjsp.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qjsp.Theatre_Management_System.Exception.ReviewIdNotFound;
import com.qjsp.Theatre_Management_System.Repo.ReviewRepository;
import com.qjsp.Theatre_Management_System.dto.Review;

@Repository
public class ReviewDao {

	@Autowired
	public ReviewRepository reviewRepository;
	
	public Review saveReview(Review review) {
		return reviewRepository.save(review);
	}
	
	public Review fetchReviewById(int reviewId) {
		Optional<Review> optional = reviewRepository.findById(reviewId);
		if(optional.isEmpty()) {
			throw new ReviewIdNotFound("No Review present with the given Id "+reviewId);
		}
		else {
			
			return reviewRepository.findById(reviewId).get();
		}
	}

	public Review deleteReviewById(int reviewId) {
		Review review = fetchReviewById(reviewId);
		reviewRepository.delete(review);
		return review;

	}

	public Review updateReviewById(int reviewId, Review review) {
		fetchReviewById(reviewId);
		review.setReviewId(reviewId);
		return saveReview(review);

	}
	
	public List<Review> fetchAll(){
		return reviewRepository.findAll();
	}
	
}
