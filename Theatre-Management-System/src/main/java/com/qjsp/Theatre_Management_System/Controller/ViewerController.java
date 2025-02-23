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

import com.qjsp.Theatre_Management_System.Service.ViewerService;
import com.qjsp.Theatre_Management_System.dto.Food;
import com.qjsp.Theatre_Management_System.dto.Viewer;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@RestController
@RequestMapping("viewer/api")
public class ViewerController {

	@Autowired
	public ViewerService viewerService;

//	http://localhost:8080/viewer/api
	@PostMapping
	public ResponseStructure<Viewer> saveViewer(@RequestBody Viewer viewer) {

		return viewerService.saveViewer(viewer);
	}

//	http://localhost:8080/viewer/api/1
	@GetMapping("{viewerId}")
	public ResponseStructure<Viewer> fetchViewerById(@PathVariable("viewerId") int viewerId) {

		return viewerService.fetchViewerById(viewerId);
	}

//	http://localhost:8080/viewer/api/8
	@DeleteMapping("{viewerId}")
	public ResponseStructure<Viewer> deleteViewerById(@PathVariable("viewerId") int viewerId) {

		return viewerService.deleteViewerById(viewerId);
	}

//	http://localhost:8080/viewer/api?viewerId=3
	@PutMapping
	public ResponseStructure<Viewer> updateViewerById(@RequestParam int viewerId, @RequestBody Viewer viewer) {
		return viewerService.updateViewerById(viewerId, viewer);
	}

//	http://localhost:8080/viewer/api
	@GetMapping
	public ResponseStructureList<Viewer> fetchAll() {
		return viewerService.fetchAll();
	}

//	Add Existing Seat to Viewer

//	http://localhost:8080/viewer/api/mapSeatToViewer
	@PutMapping("mapSeatToViewer/{seatId}/{viewerId}")
	public ResponseStructure<Viewer> mapSeatToViewer(@PathVariable int seatId, @PathVariable int viewerId) {

		return viewerService.mapSeatToViewer(seatId, viewerId);

	}
	
	

//	Adding Existing food to viewer
//	http://localhost:8080/viewer/api/mapFoodToViewer/1/2
	@PutMapping("mapFoodToViewer/{foodId}/{viewerId}")
	public ResponseStructure<Viewer> mapFoodToViewer(@PathVariable int foodId, @PathVariable int viewerId) {
		return viewerService.mapFoodToViewer(foodId, viewerId);
	}

//	Adding New Food To Existing Viewer
//	http://localhost:8080/viewer/api/mapNewFoodToViewer/3
	@PutMapping("/mapNewFoodToViewer/{viewerId}")
	public ResponseStructure<Viewer> mapNewFoodToViewer(@RequestBody Food food, @PathVariable int viewerId) {

		return viewerService.mapNewFoodToViewer(food, viewerId);
	}
	
	
	
}
