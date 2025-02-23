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

import com.qjsp.Theatre_Management_System.Service.ScreenService;
import com.qjsp.Theatre_Management_System.dto.Screen;
import com.qjsp.Theatre_Management_System.dto.Seat;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@RestController
@RequestMapping("screen/api")
public class ScreenController {

	@Autowired
	public ScreenService screenService;

//	http://localhost:8080/screen/api
	@PostMapping
	public ResponseStructure<Screen> saveScreen(@RequestBody Screen screen) {

		return screenService.saveScreen(screen);
	}

//	http://localhost:8080/screen/api/1
	@GetMapping("{screenId}")
	public ResponseStructure<Screen> fetchScreenById(@PathVariable("screenId") int screenId) {

		return screenService.fetchScreenById(screenId);
	}

//	http://localhost:8080/screen/api/8
	@DeleteMapping("{screenId}")
	public ResponseStructure<Screen> deleteScreenById(@PathVariable("screenId") int screenId) {

		return screenService.deleteScreenById(screenId);
	}

//	http://localhost:8080/screen/api?screenId=3
	@PutMapping
	public ResponseStructure<Screen> updateScreenById(@RequestParam int screenId, @RequestBody Screen screen) {
		return screenService.updateScreenById(screenId, screen);
	}

//	http://localhost:8080/screen/api
	@GetMapping
	public ResponseStructureList<Screen> fetchAll() {
		return screenService.fetchAll();
	}

//	Add Existing Seats to the screen
//	http://localhost:8080/screen/api/addExistingSeatToScreen/1/2
	@PutMapping("addExistingSeatToScreen/{seatId}/{screenId}")
	public Screen addExistingSeatToScreen(@PathVariable int seatId, @PathVariable int screenId) {
		return screenService.addExistingSeatToScreen(seatId, screenId);

	}

//  http://localhost:8080/screen/api/addNewSeatToScreen/2
	@PutMapping("addNewSeatToScreen/{screenId}")
	public Screen addNewSeatToScreen(@RequestBody Seat seat,@PathVariable int screenId) {
		return screenService.addNewSeatToScreen(seat, screenId);
	}
	
//	Add Existing Movie to Screen

//	http://localhost:8080/screen/api/mapMovieToScreen
	@PutMapping("mapMovieToScreen/{movieId}/{screenId}")
	public ResponseStructure<Screen> mapMovieToScreen(@PathVariable int movieId, @PathVariable int screenId) {

		return screenService.mapMovieToScreen(movieId, screenId);

	}
	

}
