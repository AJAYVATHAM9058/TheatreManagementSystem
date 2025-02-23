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

import com.qjsp.Theatre_Management_System.Service.ManagerService;
import com.qjsp.Theatre_Management_System.dto.Manager;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@RestController
@RequestMapping("manager/api")
public class ManagerController {

	@Autowired
	public ManagerService managerService;
	
//	http://localhost:8080/manager/api
	@PostMapping
	public ResponseStructure<Manager> saveManager(@RequestBody Manager manager) {
	
		return managerService.saveManager(manager);
	}
	
//	http://localhost:8080/manager/api/1
	@GetMapping ("{managerId}")
	public ResponseStructure<Manager> fetchManagerById(@PathVariable("managerId") int managerId) {
		
		return managerService.fetchManagerById(managerId);
	}
	
//	http://localhost:8080/manager/api/8
	@DeleteMapping("{managerId}")
	public ResponseStructure<Manager> deleteManagerById(@PathVariable("managerId") int managerId) {
		
		return managerService.deleteManagerById(managerId);
	}
	
//	http://localhost:8080/manager/api?managerId=3
	@PutMapping
	public ResponseStructure<Manager> updateManagerById(@RequestParam int managerId,@RequestBody Manager manager) {
		return managerService.updateManagerById(managerId, manager);
	}
	
//	http://localhost:8080/manager/api
	@GetMapping
	public ResponseStructureList<Manager> fetchAll() {
		return managerService.fetchAll();
	}
	
}
