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

import com.qjsp.Theatre_Management_System.Service.StaffService;
import com.qjsp.Theatre_Management_System.dto.Staff;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@RestController
@RequestMapping("staff/api")
public class StaffController {

	
	@Autowired
	public StaffService staffService;
	
//	http://localhost:8080/staff/api
	@PostMapping
	public ResponseStructure<Staff> saveStaff(@RequestBody Staff staff) {
	
		return staffService.saveStaff(staff);
	}
	
//	http://localhost:8080/staff/api/1
	@GetMapping ("{staffId}")
	public ResponseStructure<Staff> fetchStaffById(@PathVariable("staffId") int staffId) {
		
		return staffService.fetchStaffById(staffId);
	}
	
//	http://localhost:8080/staff/api/8
	@DeleteMapping("{staffId}")
	public ResponseStructure<Staff> deleteStaffById(@PathVariable("staffId") int staffId) {
		
		return staffService.deleteStaffById(staffId);
	}
	
//	http://localhost:8080/staff/api?staffId=3
	@PutMapping
	public ResponseStructure<Staff> updateStaffById(@RequestParam int staffId,@RequestBody Staff staff) {
		return staffService.updateStaffById(staffId, staff);
	}
	
//	http://localhost:8080/staff/api
	@GetMapping
	public ResponseStructureList<Staff> fetchAll() {
		return staffService.fetchAll();
	}
	
	
}
