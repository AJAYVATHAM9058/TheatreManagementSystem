package com.qjsp.Theatre_Management_System.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qjsp.Theatre_Management_System.dto.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer> {

}
