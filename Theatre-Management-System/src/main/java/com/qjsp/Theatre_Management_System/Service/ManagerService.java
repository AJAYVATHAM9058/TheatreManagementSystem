package com.qjsp.Theatre_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qjsp.Theatre_Management_System.dao.ManagerDao;
import com.qjsp.Theatre_Management_System.dto.Manager;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@Service
public class ManagerService {

	@Autowired
	public ManagerDao managerDao;

	@Autowired
	ResponseStructure<Manager> responseStructure;
	
	@Autowired
	ResponseStructureList<Manager> responseStructureList;

	public ResponseStructure<Manager> saveManager(Manager manager) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Manager Data Inserted into DataBase");
		responseStructure.setData(managerDao.saveManager(manager));
		return responseStructure;
	}

	public ResponseStructure<Manager> fetchManagerById(int managerId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Manager Data Retrieved from DataBase");
		responseStructure.setData(managerDao.fetchManagerById(managerId));
		return responseStructure;
	}

	public ResponseStructure<Manager> deleteManagerById(int managerId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Manager Data Deleted From DataBase");
		responseStructure.setData(managerDao.deleteManagerById(managerId));
		return responseStructure;
	}

	public ResponseStructure<Manager> updateManagerById(int managerId, Manager manager) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Manager Data Updated From DataBase");
		responseStructure.setData(managerDao.updateManagerById(managerId, manager));
		return responseStructure;
	}

	public ResponseStructureList<Manager> fetchAll() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("Successfully fetched all the Managers from Database");
		responseStructureList.setData(managerDao.fetchAll());

		return responseStructureList;
	}

}
