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

import com.qjsp.Theatre_Management_System.Service.OwnerService;
import com.qjsp.Theatre_Management_System.dto.Owner;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/owner/api")
public class OwnerController {

	@Autowired
	public OwnerService ownerService;

//	http://localhost:8080/owner/api/saveOwner
	@Operation(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses( value= {
			@ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id")		
	})
	@PostMapping("/saveOwner")
	public ResponseStructure<Owner> saveOwner(@RequestBody Owner owner) {

		return ownerService.saveOwner(owner);
	}
 
//	http://localhost:8080/owner/api/1
	
	@Operation(summary = "Delete the Owner with given Id", description = "API is used to delete the owner")
	@ApiResponses( value= {
			@ApiResponse(responseCode = "200", description = "OK Successfully Owner Deleted"),
			@ApiResponse(responseCode = "404", description = "Owner Not found in the Data base"),
			@ApiResponse(responseCode = "204", description = "Owner Deleted Successfully")		
	})
	
	@DeleteMapping("/{owner-id}")
	public ResponseStructure<Owner> deleteOwnerById(@PathVariable("owner-id") int ownerId) {
		ResponseStructure<Owner> owner = ownerService.deleteOwnerById(ownerId);
		return owner;
	}

//	http://localhost:8080/owner/api/1
	@GetMapping("/{id}")
	public ResponseStructure<Owner> fetchOwnerById(@PathVariable("id") int ownerId) {
		return ownerService.fetchOwnerById(ownerId);
	}

//	http://localhost:8080/owner/api/updateOwnerById?ownerId=1
	@PutMapping("updateOwnerById")
	public ResponseStructure<Owner> updateOwnerById(@RequestParam("ownerId") int ownerId, @RequestBody Owner owner) {
		return ownerService.updateOwnerById(ownerId, owner);
	}

//	http://localhost:8080/owner/api/fetchAll
	@GetMapping("fetchAll")
	public ResponseStructureList<Owner> fetchAll() {
		return ownerService.fetchAll();
	}

//	http://localhost:8080/owner/api/mapTheatreToOwner/
	@PutMapping ("mapTheatreToOwner/{theatreId}/{ownerId}")
	public Owner mapTheatreToOwner(@PathVariable int theatreId,@PathVariable int ownerId) {
		return ownerService.mapTheatreToOwner(theatreId, ownerId);
	}

}
