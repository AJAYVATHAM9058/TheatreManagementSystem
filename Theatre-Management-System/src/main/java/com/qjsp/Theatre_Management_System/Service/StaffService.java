package com.qjsp.Theatre_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qjsp.Theatre_Management_System.dao.StaffDao;
import com.qjsp.Theatre_Management_System.dto.Staff;
import com.qjsp.Theatre_Management_System.dto.Staff;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@Service
public class StaffService {


	@Autowired
	StaffDao staffDao;

	@Autowired
	ResponseStructure<Staff> responseStructure;

	@Autowired
	ResponseStructureList<Staff> responseStructureList;
	
	public ResponseStructure<Staff> saveStaff(Staff staff) {

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Staff Data Inserted into DataBase");
		responseStructure.setData(staffDao.saveStaff(staff));
		return responseStructure;
		
	}

	public ResponseStructure<Staff> deleteStaffById(int staffId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Staff Data Deleted From DataBase");
		responseStructure.setData(staffDao.deleteStaffById(staffId));
		return responseStructure;
	}

	public ResponseStructure<Staff> fetchStaffById(int staffId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Staff Data Retrieved from DataBase");
		responseStructure.setData(staffDao.fetchStaffById(staffId));
		return responseStructure;
	}

	public ResponseStructure<Staff> updateStaffById(int staffId, Staff staff) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Staff Data Updated From DataBase");
		responseStructure.setData(staffDao.updateStaffById(staffId, staff));
		return responseStructure;
	}

	public ResponseStructureList<Staff> fetchAll() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("Successfully fetched all the Staff Members from Database");
		responseStructureList.setData(staffDao.fetchAll());

		return responseStructureList;
	}

}
