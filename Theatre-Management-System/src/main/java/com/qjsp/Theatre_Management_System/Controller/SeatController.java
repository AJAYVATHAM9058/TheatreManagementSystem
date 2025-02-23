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

import com.qjsp.Theatre_Management_System.Service.SeatService;
import com.qjsp.Theatre_Management_System.dto.Seat;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@RestController
@RequestMapping("seat/api")
public class SeatController {

	
	@Autowired
	public SeatService seatService;
	
//	http://localhost:8080/seat/api
	@PostMapping
	public ResponseStructure<Seat> saveSeat(@RequestBody Seat seat) {
	
		return seatService.saveSeat(seat);
	}
	
//	http://localhost:8080/seat/api/1
	@GetMapping ("{seatId}")
	public ResponseStructure<Seat> fetchSeatById(@PathVariable("seatId") int seatId) {
		
		return seatService.fetchSeatById(seatId);
	}
	
//	http://localhost:8080/seat/api/8
	@DeleteMapping("{seatId}")
	public ResponseStructure<Seat> deleteSeatById(@PathVariable("seatId") int seatId) {
		
		return seatService.deleteSeatById(seatId);
	}
	
//	http://localhost:8080/seat/api?seatId=3
	@PutMapping
	public ResponseStructure<Seat> updateSeatById(@RequestParam int seatId,@RequestBody Seat seat) {
		return seatService.updateSeatById(seatId, seat);
	}
	
//	http://localhost:8080/seat/api
	@GetMapping
	public ResponseStructureList<Seat> fetchAll() {
		return seatService.fetchAll();
	}
	
	
}
