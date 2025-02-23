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

import com.qjsp.Theatre_Management_System.Service.BranchService;
import com.qjsp.Theatre_Management_System.dto.Branch;
import com.qjsp.Theatre_Management_System.dto.Screen;
import com.qjsp.Theatre_Management_System.dto.Staff;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@RestController
@RequestMapping("/branch/api")
public class BranchController {

	@Autowired
	public BranchService branchService;

//	http://localhost:8080/branch/api
	@PostMapping
	public ResponseStructure<Branch> saveBranch(@RequestBody Branch branch) {

		return branchService.saveBranch(branch);
	}

//	http://localhost:8080/branch/api/1
	@GetMapping("{branchId}")
	public ResponseStructure<Branch> fetchBranchById(@PathVariable("branchId") int branchId) {

		return branchService.fetchBranchById(branchId);
	}

//	http://localhost:8080/branch/api/8
	@DeleteMapping("{branchId}")
	public ResponseStructure<Branch> deleteBranchById(@PathVariable("branchId") int branchId) {

		return branchService.deleteBranchById(branchId);
	}

//	http://localhost:8080/branch/api?branchId=3
	@PutMapping
	public ResponseStructure<Branch> updateBranchById(@RequestParam int branchId, @RequestBody Branch branch) {
		return branchService.updateBranchById(branchId, branch);
	}

//	http://localhost:8080/branch/api
	@GetMapping
	public ResponseStructureList<Branch> fetchAll() {
		return branchService.fetchAll();
	}

//	Add Existing Manager to Branch

//	http://localhost:8080/branch/api
	@PutMapping("mapManagerToBranch/{managerId}/{branchId}")
	public ResponseStructure<Branch> mapManagerToBranch(@PathVariable int managerId, @PathVariable int branchId) {

		return branchService.mapManagerToBranch(managerId, branchId);

	}

//	Add Existing Address to Branch
//	http://localhost:8080/branch/api/mapExistingAddressToBranch/1/2
	@PutMapping("mapExistingAddressToBranch/{addressId}/{branchId}")
	public ResponseStructure<Branch> mapExistingAddressToBranch(@PathVariable int addressId,
			@PathVariable int branchId) {
		return branchService.mapExistingAddressToBranch(addressId, branchId);
	}

//	Adding Existing staff to branch
//	http://localhost:8080/branch/api/mapStaffToBranch/1/2
	@PutMapping("mapStaffToBranch/{staffId}/{branchId}")
	public ResponseStructure<Branch> mapStaffToBranch(@PathVariable int staffId, @PathVariable int branchId) {
		return branchService.mapStaffToBranch(staffId, branchId);
	}

//	Adding New Staff To Existing Branch
//	http://localhost:8080/branch/api/mapNewStaffToBranch/3
	@PutMapping("/mapNewStaffToBranch/{branchId}")
	public ResponseStructure<Branch> mapNewStaffToBranch(@RequestBody Staff staff, @PathVariable int branchId) {

		return branchService.mapNewStaffToBranch(staff, branchId);
	}
	
	
//	Adding Existing Screen to branch
//	http://localhost:8080/branch/api/mapScreenToBranch/1/2
	@PutMapping("mapScreenToBranch/{screenId}/{branchId}")
	public ResponseStructure<Branch> mapScreenToBranch(@PathVariable int screenId, @PathVariable int branchId) {
		return branchService.mapScreenToBranch(screenId, branchId);
	}
	
//	Adding New Screen To Existing Branch
//	http://localhost:8080/branch/api/mapNewScreenToBranch/3
	@PutMapping("/mapNewScreenToBranch/{branchId}")
	public ResponseStructure<Branch> mapNewScreenToBranch(@RequestBody Screen screen, @PathVariable int branchId) {
		
		return branchService.mapNewScreenToBranch(screen, branchId);
	}

}
