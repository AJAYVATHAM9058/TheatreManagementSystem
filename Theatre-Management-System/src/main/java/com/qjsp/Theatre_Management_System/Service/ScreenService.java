package com.qjsp.Theatre_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qjsp.Theatre_Management_System.dao.MovieDao;
import com.qjsp.Theatre_Management_System.dao.ScreenDao;
import com.qjsp.Theatre_Management_System.dao.SeatDao;
import com.qjsp.Theatre_Management_System.dto.Movie;
import com.qjsp.Theatre_Management_System.dto.Screen;
import com.qjsp.Theatre_Management_System.dto.Seat;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@Service
public class ScreenService {

	@Autowired
	ScreenDao screenDao;

	@Autowired
	SeatDao seatDao;
	
	@Autowired
	MovieDao movieDao;

	@Autowired
	ResponseStructure<Screen> responseStructure;

	@Autowired
	ResponseStructureList<Screen> responseStructureList;
	
	public ResponseStructure<Screen> saveScreen(Screen screen) {

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Screen Data Inserted into DataBase");
		responseStructure.setData(screenDao.saveScreen(screen));
		return responseStructure;

	}

	public ResponseStructure<Screen> deleteScreenById(int screenId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Screen Data Deleted From DataBase");
		responseStructure.setData(screenDao.deleteScreenById(screenId));
		return responseStructure;
	}

	public ResponseStructure<Screen> fetchScreenById(int screenId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Screen Data Retrieved from DataBase");
		responseStructure.setData(screenDao.fetchScreenById(screenId));
		return responseStructure;
	}

	public ResponseStructure<Screen> updateScreenById(int screenId, Screen screen) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Screen Data Updated From DataBase");
		responseStructure.setData(screenDao.updateScreenById(screenId, screen));
		return responseStructure;
	}

	public ResponseStructureList<Screen> fetchAll() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("Successfully fetched all the Screens from Database");
		responseStructureList.setData(screenDao.fetchAll());

		return responseStructureList;
	}

//	Add Existing seats to the screen
	public Screen addExistingSeatToScreen(int seatId, int screenId) {
		Seat seat = seatDao.fetchSeatById(seatId);
		Screen screen = screenDao.fetchScreenById(screenId);
		List<Seat> list = screen.getSeats();
		list.add(seat);
		screen.setSeats(list);
		return screenDao.saveScreen(screen);

	}

//	Add New Seat to Screen
	public Screen addNewSeatToScreen(Seat seat, int screenId) {
		Screen screen = screenDao.fetchScreenById(screenId);
		List<Seat> list = screen.getSeats();
		list.add(seat);
		screen.setSeats(list);
		return screenDao.saveScreen(screen);
	}
	
//	Adding existing Movie to Screen
	public ResponseStructure<Screen> mapMovieToScreen(int movieId, int screenId) {
		Movie movie = movieDao.fetchMovieById(movieId);
		Screen screen = screenDao.fetchScreenById(screenId);
		screen.setMovie(movie);

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Added Existing Movie " + movie.getMovieName() + "  To  Screen");
		responseStructure.setData(screenDao.saveScreen(screen));
		return responseStructure;

	}

}
