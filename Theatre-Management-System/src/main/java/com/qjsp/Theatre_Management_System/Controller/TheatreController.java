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

import com.qjsp.Theatre_Management_System.Service.TheatreService;
import com.qjsp.Theatre_Management_System.dto.Branch;
import com.qjsp.Theatre_Management_System.dto.Theatre;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@RestController
@RequestMapping("/theatre/api")
public class TheatreController {

	@Autowired
	public TheatreService service;

//	http://localhost:8080/theatre/api/saveTheatre
	@PostMapping("saveTheatre")
	public ResponseStructure<Theatre> saveTheatre(@RequestBody Theatre theatre) {
		return service.saveTheatre(theatre);
	}

//	http://localhost:8080/theatre/api/2
	@GetMapping("{id}")
	public ResponseStructure<Theatre> fetchTheatreById(@PathVariable("id") int id) {
		return service.fetchTheatreById(id);
	}

//	http://localhost:8080/theatre/api/2
	@DeleteMapping("{id}")
	public ResponseStructure<Theatre> deleteTheatreById(@PathVariable("id") int id) {
		return service.deleteTheatreById(id);
	}

//	http://localhost:8080/theatre/api/fetchAll
	@GetMapping("fetchAll")
	public ResponseStructureList<Theatre> fetchAll() {
		return service.fetchAll();
	}

//  http://localhost:8080/theatre/api/updateTheatreById?theatreId=4
	@PutMapping("updateTheatreById")
	public ResponseStructure<Theatre> updateTheatre(@RequestParam("theatreId") int theatreId, @RequestBody Theatre theatre) {

		return service.updateTheatre(theatreId, theatre);
	}
	
	
//	Adding Existing Branch to Existing theatre
	
//	http://localhost:8080/theatre/api/mapBranchToTheatre
	@PutMapping("mapBranchToTheatre/{branchId}/{theatreId}")
	public Theatre mapBranchToTheatre(@PathVariable int branchId,@PathVariable int theatreId) {
		
		return service.mapBranchToTheatre(branchId, theatreId);
	}

//	Adding New Branch To Existing Theatre
//	http://localhost:8080/theatre/api/mapNewBranchToTheatre/3
	@PutMapping("mapNewBranchToTheatre/{theatreId}")
	public Theatre mapNewBranchToTheatre(@RequestBody Branch branch,@PathVariable int theatreId) {
		return service.mapNewBranchToTheatre(branch, theatreId);
	}
	
}
