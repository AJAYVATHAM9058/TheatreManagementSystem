package com.qjsp.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qjsp.Theatre_Management_System.Exception.SeatIdNotFound;
import com.qjsp.Theatre_Management_System.Repo.SeatRepository;
import com.qjsp.Theatre_Management_System.dto.Seat;

@Repository
public class SeatDao {

	@Autowired
	public SeatRepository seatRepository;
	
	public Seat saveSeat(Seat seat) {
		return seatRepository.save(seat);
	}
	
	public Seat fetchSeatById(int seatId) {

		Optional<Seat> optional = seatRepository.findById(seatId);
		if(optional.isEmpty()) {
			throw new SeatIdNotFound("No Seat present with the given Id "+seatId);
		}
		else {
			
			return seatRepository.findById(seatId).get();
		}
	}

	public Seat deleteSeatById(int seatId) {
		Seat seat = fetchSeatById(seatId);
		seatRepository.delete(seat);
		return seat;

	}

	public Seat updateSeatById(int seatId, Seat seat) {
		fetchSeatById(seatId);
		seat.setSeatId(seatId);
		return saveSeat(seat);

	}
	
	public List<Seat> fetchAll(){
		return seatRepository.findAll();
	}
	
}
