package com.qjsp.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qjsp.Theatre_Management_System.Exception.StaffIdNotFound;
import com.qjsp.Theatre_Management_System.Repo.StaffRepository;
import com.qjsp.Theatre_Management_System.dto.Staff;


@Repository
public class StaffDao {
	
	@Autowired
	public StaffRepository staffRepository;
	
	public Staff saveStaff(Staff staff) {
		return staffRepository.save(staff);
	}
	
	public Staff fetchStaffById(int staffId) {
		Optional<Staff> optional = staffRepository.findById(staffId);
		if(optional.isEmpty()) {
			throw new StaffIdNotFound("No Staff present with the given Id "+staffId);
		}
		else {
			
			return staffRepository.findById(staffId).get();
		}
	}

	public Staff deleteStaffById(int staffId) {
		Staff staff = fetchStaffById(staffId);
		staffRepository.delete(staff);
		return staff;

	}

	public Staff updateStaffById(int staffId, Staff staff) {
		fetchStaffById(staffId);
		staff.setStaffId(staffId);
		return saveStaff(staff);

	}
	
	public List<Staff> fetchAll(){
		return staffRepository.findAll();
	}
	
	
}
