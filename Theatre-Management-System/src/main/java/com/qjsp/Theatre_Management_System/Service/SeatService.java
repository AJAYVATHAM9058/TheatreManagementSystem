package com.qjsp.Theatre_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qjsp.Theatre_Management_System.dao.SeatDao;
import com.qjsp.Theatre_Management_System.dto.Seat;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@Service
public class SeatService {

	@Autowired
	SeatDao seatDao;

	@Autowired
	ResponseStructure<Seat> responseStructure;

	@Autowired
	ResponseStructureList<Seat> responseStructureList;
	
	public ResponseStructure<Seat> saveSeat(Seat seat) {

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Seat Data Inserted into DataBase");
		responseStructure.setData(seatDao.saveSeat(seat));
		return responseStructure;

	}

	public ResponseStructure<Seat> deleteSeatById(int seatId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Seat Data Deleted From DataBase");
		responseStructure.setData(seatDao.deleteSeatById(seatId));
		return responseStructure;
	}

	public ResponseStructure<Seat> fetchSeatById(int seatId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Seat Data Retrieved from DataBase");
		responseStructure.setData(seatDao.fetchSeatById(seatId));
		return responseStructure;
	}

	public ResponseStructure<Seat> updateSeatById(int seatId, Seat seat) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Seat Data Updated From DataBase");
		responseStructure.setData(seatDao.updateSeatById(seatId, seat));
		return responseStructure;
	}

	public ResponseStructureList<Seat> fetchAll() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("Successfully fetched all the Seats from Database");
		responseStructureList.setData(seatDao.fetchAll());

		return responseStructureList;
	}
}
