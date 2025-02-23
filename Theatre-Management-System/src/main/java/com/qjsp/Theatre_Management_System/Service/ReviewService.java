package com.qjsp.Theatre_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qjsp.Theatre_Management_System.dao.ReviewDao;
import com.qjsp.Theatre_Management_System.dto.Review;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@Service
public class ReviewService {


	@Autowired
	ReviewDao reviewDao;

	@Autowired
	ResponseStructure<Review> responseStructure;

	@Autowired
	ResponseStructureList<Review> responseStructureList;
	
	public ResponseStructure<Review> saveReview(Review review) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Review Data Inserted into DataBase");
		responseStructure.setData(reviewDao.saveReview(review));
		return responseStructure;
		
	}

	public ResponseStructure<Review> deleteReviewById(int reviewId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Review Data Deleted From DataBase");
		responseStructure.setData(reviewDao.deleteReviewById(reviewId));
		return responseStructure;
	}

	public ResponseStructure<Review> fetchReviewById(int reviewId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Review Data Retrieved from DataBase");
		responseStructure.setData(reviewDao.fetchReviewById(reviewId));
		return responseStructure;
	}

	public ResponseStructure<Review> updateReviewById(int reviewId, Review review) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Review Data Updated From DataBase");
		responseStructure.setData(reviewDao.updateReviewById(reviewId, review));
		return responseStructure;
	}

	public ResponseStructureList<Review> fetchAll() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("Successfully fetched all the Reviews from Database");
		responseStructureList.setData(reviewDao.fetchAll());

		return responseStructureList;
	}
	
}
