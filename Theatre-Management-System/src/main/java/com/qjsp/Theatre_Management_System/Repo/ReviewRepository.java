package com.qjsp.Theatre_Management_System.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qjsp.Theatre_Management_System.dto.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
