package com.qjsp.Theatre_Management_System.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qjsp.Theatre_Management_System.Exception.OwnerIdNotFound;
import com.qjsp.Theatre_Management_System.dao.OwnerDao;
import com.qjsp.Theatre_Management_System.dao.TheatreDao;
import com.qjsp.Theatre_Management_System.dto.Owner;
import com.qjsp.Theatre_Management_System.dto.Theatre;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@Service
public class OwnerService {

	@Autowired
	OwnerDao ownerDao;
	
	@Autowired
	TheatreDao  theatreDao;

	@Autowired
	ResponseStructure<Owner> responseStructure;

	@Autowired
	ResponseStructureList<Owner> responseStructureList;
	
	public ResponseStructure<Owner> saveOwner(Owner owner) {

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Owner Data Inserted into DataBase");
		responseStructure.setData(ownerDao.saveOwner(owner));
		return responseStructure;
		
	}

	public ResponseStructure<Owner> deleteOwnerById(int ownerId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Owner Data Deleted From DataBase");
		responseStructure.setData(ownerDao.deleteOwnerById(ownerId));
		return responseStructure;
	}

	public ResponseStructure<Owner> fetchOwnerById(int ownerId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Owner Data Retrieved from DataBase");
		responseStructure.setData(ownerDao.fetchOwnerById(ownerId));
		return responseStructure;
		
	}

	public ResponseStructure<Owner> updateOwnerById(int ownerId, Owner owner) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Owner Data Updated From DataBase");
		responseStructure.setData(ownerDao.updateOwnerById(ownerId, owner));
		return responseStructure;
	}

	public ResponseStructureList<Owner> fetchAll() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("Successfully fetched all the Owners from Database");
		responseStructureList.setData(ownerDao.fetchAll());

		return responseStructureList;
	}
	
	
	//Mapping Existing Owner With Existing Theatre
	
	public Owner mapTheatreToOwner(int theatreId,int ownerId) {
		
		Theatre theatre = theatreDao.fetchTheatreById(theatreId);
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		
		owner.setTheatre(theatre);
		
		return ownerDao.saveOwner(owner);
		
	}
	

}
