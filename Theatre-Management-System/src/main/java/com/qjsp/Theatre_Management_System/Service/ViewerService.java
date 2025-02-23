package com.qjsp.Theatre_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qjsp.Theatre_Management_System.dao.FoodDao;
import com.qjsp.Theatre_Management_System.dao.SeatDao;
import com.qjsp.Theatre_Management_System.dao.ViewerDao;
import com.qjsp.Theatre_Management_System.dto.Food;
import com.qjsp.Theatre_Management_System.dto.Seat;
import com.qjsp.Theatre_Management_System.dto.Viewer;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;


@Service
public class ViewerService {

	@Autowired
	ViewerDao viewerDao;
	
	@Autowired
	SeatDao seatDao;
	
	@Autowired
	FoodDao foodDao;

	@Autowired
	ResponseStructure<Viewer> responseStructure;

	@Autowired
	ResponseStructureList<Viewer> responseStructureList;
	
	public ResponseStructure<Viewer> saveViewer(Viewer viewer) {

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Viewer Data Inserted into DataBase");
		responseStructure.setData(viewerDao.saveViewer(viewer));
		return responseStructure;
		
	}

	public ResponseStructure<Viewer> deleteViewerById(int viewerId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Viewer Data Deleted From DataBase");
		responseStructure.setData(viewerDao.deleteViewerById(viewerId));
		return responseStructure;
	}

	public ResponseStructure<Viewer> fetchViewerById(int viewerId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Viewer Data Retrieved from DataBase");
		responseStructure.setData(viewerDao.fetchViewerById(viewerId));
		return responseStructure;
	}

	public ResponseStructure<Viewer> updateViewerById(int viewerId, Viewer viewer) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Viewer Data Updated From DataBase");
		responseStructure.setData(viewerDao.updateViewerById(viewerId, viewer));
		return responseStructure;
	}

	public ResponseStructureList<Viewer> fetchAll() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("Successfully fetched all the Viewers from Database");
		responseStructureList.setData(viewerDao.fetchAll());

		return responseStructureList;
	}
	
//	Adding existing Seat to Viewer
	public ResponseStructure<Viewer> mapSeatToViewer(int seatId, int viewerId) {
		Seat seat = seatDao.fetchSeatById(seatId);
		Viewer viewer = viewerDao.fetchViewerById(viewerId);
		viewer.setSeat(seat);

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Added Existing Seat   To  Viewer");
		responseStructure.setData(viewerDao.saveViewer(viewer));
		return responseStructure;

	}
	
	

//	Adding existing Food to Existing Viewer
	public ResponseStructure<Viewer> mapFoodToViewer(int foodId, int viewerId) {

		Food food = foodDao.fetchFoodById(foodId);
		Viewer viewer = viewerDao.fetchViewerById(viewerId);
		List<Food> list = viewer.getFood();
		list.add(food);
		viewer.setFood(list);

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Added Existing Food to Viewer ");
		responseStructure.setData(viewerDao.saveViewer(viewer));
		return responseStructure;

	}

//	Adding New Food to existing viewer
	public ResponseStructure<Viewer> mapNewFoodToViewer(Food food, int viewerId) {
		Viewer viewer = viewerDao.fetchViewerById(viewerId);
		List<Food> list = viewer.getFood();
		list.add(food);
		viewer.setFood(list);

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Added New Food to Viewer ");
		responseStructure.setData(viewerDao.saveViewer(viewer));
		return responseStructure;

	}

	
	
}
