package com.qjsp.Theatre_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qjsp.Theatre_Management_System.dao.BranchDao;
import com.qjsp.Theatre_Management_System.dao.TheatreDao;
import com.qjsp.Theatre_Management_System.dto.Branch;
import com.qjsp.Theatre_Management_System.dto.Theatre;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@Service
public class TheatreService {

	@Autowired
	public TheatreDao theatreDao;

	@Autowired
	public BranchDao branchDao;
	
	@Autowired
	ResponseStructure<Theatre> responseStructure;

	@Autowired
	ResponseStructureList<Theatre> responseStructureList;

	public ResponseStructure<Theatre> saveTheatre(Theatre theatre) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Theatre Data Inserted into DataBase");
		responseStructure.setData(theatreDao.saveTheatre(theatre));
		return responseStructure;
	}

	public ResponseStructure<Theatre> fetchTheatreById(int theatreId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Theatre Data Retrieved from DataBase");
		responseStructure.setData(theatreDao.fetchTheatreById(theatreId));
		return responseStructure;
	}

	public ResponseStructure<Theatre> deleteTheatreById(int theatreId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Theatre Data Deleted From DataBase");
		responseStructure.setData(theatreDao.deleteTheatreById(theatreId));
		return responseStructure;
	}

	public ResponseStructureList<Theatre> fetchAll() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("Successfully fetched all the Theatres from Database");
		responseStructureList.setData(theatreDao.fetchAll());

		return responseStructureList;
	}

	public ResponseStructure<Theatre> updateTheatre(int theatreId, Theatre theatre) {

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Theatre Data Updated From DataBase");
		responseStructure.setData(theatreDao.updateTheatre(theatreId, theatre));
		return responseStructure;
	}

	// Mapping existing branches to existing Theatre
	public Theatre mapBranchToTheatre(int branchId, int theatreId) {

		Branch branch = branchDao.fetchBranchById(branchId);
		Theatre theatre = theatreDao.fetchTheatreById(theatreId);
		List<Branch> list = theatre.getBranches();
		list.add(branch);
		theatre.setBranches(list);
		return theatreDao.saveTheatre(theatre);

	}

//	Adding new Branach to existing theatre
	public Theatre mapNewBranchToTheatre(Branch branch, int theatreId) {

		Theatre theatre = theatreDao.fetchTheatreById(theatreId);
		List<Branch> list = theatre.getBranches();
		list.add(branch);
		theatre.setBranches(list);
		return theatreDao.saveTheatre(theatre);
	}

}
