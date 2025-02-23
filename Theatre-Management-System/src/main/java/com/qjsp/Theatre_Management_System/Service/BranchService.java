package com.qjsp.Theatre_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qjsp.Theatre_Management_System.dao.AddressDao;
import com.qjsp.Theatre_Management_System.dao.BranchDao;
import com.qjsp.Theatre_Management_System.dao.ManagerDao;
import com.qjsp.Theatre_Management_System.dao.ScreenDao;
import com.qjsp.Theatre_Management_System.dao.StaffDao;
import com.qjsp.Theatre_Management_System.dto.Address;
import com.qjsp.Theatre_Management_System.dto.Branch;
import com.qjsp.Theatre_Management_System.dto.Manager;
import com.qjsp.Theatre_Management_System.dto.Screen;
import com.qjsp.Theatre_Management_System.dto.Staff;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@Service
public class BranchService {

	@Autowired
	BranchDao branchDao;

	@Autowired
	ManagerDao managerDao;

	@Autowired
	AddressDao addressDao;

	@Autowired
	StaffDao staffDao;
	
	@Autowired
	ScreenDao screenDao;

	@Autowired
	ResponseStructure<Branch> responseStructure;
	
	@Autowired
	ResponseStructureList<Branch> responseStructureList;
	
	public ResponseStructure<Branch> saveBranch(Branch branch) {

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Branch Data Inserted into DataBase");
		responseStructure.setData(branchDao.saveBranch(branch));
		return responseStructure;
	}

	public ResponseStructure<Branch> fetchBranchById(int branchId) {

		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Branch Data Retrieved from DataBase");
		responseStructure.setData(branchDao.fetchBranchById(branchId));
		return responseStructure;
	}

	public ResponseStructure<Branch> deleteBranchById(int branchId) {

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Branch Data Deleted From DataBase");
		responseStructure.setData(branchDao.deleteBranchById(branchId));
		return responseStructure;
	}

	public ResponseStructure<Branch> updateBranchById(int branchId, Branch branch) {

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Branch Data Updated From DataBase");
		responseStructure.setData(branchDao.updateBranchById(branchId, branch));
		return responseStructure;
	}

	public ResponseStructureList<Branch> fetchAll() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("Successfully fetched all the Branches from Database");
		responseStructureList.setData(branchDao.fetchAll());

		return responseStructureList;
	}

//	Adding existing Manager to Branch
	public ResponseStructure<Branch> mapManagerToBranch(int managerId, int BranchId) {
		Manager manager = managerDao.fetchManagerById(managerId);
		Branch branch = branchDao.fetchBranchById(BranchId);
		branch.setManager(manager);

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Added Existing Manager " + manager.getManagerName() + "  To "
				+ branch.getBranchName() + " Branch");
		responseStructure.setData(branchDao.saveBranch(branch));
		return responseStructure;

	}

//	Adding existing address to existing branch

	public ResponseStructure<Branch> mapExistingAddressToBranch(int addressId, int branchId) {

		Address address = addressDao.fetchAddressById(addressId);
		Branch branch = branchDao.fetchBranchById(branchId);
		branch.setAddress(address);

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Added Existing Address to Branch ");
		responseStructure.setData(branchDao.saveBranch(branch));
		return responseStructure;

	}

//	Adding existing Staff to Existing Branch
	public ResponseStructure<Branch> mapStaffToBranch(int staffId, int branchId) {

		Staff staff = staffDao.fetchStaffById(staffId);
		Branch branch = branchDao.fetchBranchById(branchId);
		List<Staff> list = branch.getStaff();
		list.add(staff);
		branch.setStaff(list);

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Added Existing Staff to Branch ");
		responseStructure.setData(branchDao.saveBranch(branch));
		return responseStructure;

	}

//	Adding New Staff to existing branch
	public ResponseStructure<Branch> mapNewStaffToBranch(Staff staff, int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		List<Staff> list = branch.getStaff();
		list.add(staff);
		branch.setStaff(list);

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Added New Staff to Branch ");
		responseStructure.setData(branchDao.saveBranch(branch));
		return responseStructure;

	}

	

//	Adding existing Screen to Existing Branch
	public ResponseStructure<Branch> mapScreenToBranch(int screenId, int branchId) {

		Screen screen = screenDao.fetchScreenById(screenId);
		Branch branch = branchDao.fetchBranchById(branchId);
		List<Screen> list = branch.getScreen();
		list.add(screen);
		branch.setScreen(list);

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Added Existing Screen to Branch ");
		responseStructure.setData(branchDao.saveBranch(branch));
		return responseStructure;

	}

//	Adding New Screen to existing branch
	public ResponseStructure<Branch> mapNewScreenToBranch(Screen screen, int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		List<Screen> list = branch.getScreen();
		list.add(screen);
		branch.setScreen(list);

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Added New Screen to Branch ");
		responseStructure.setData(branchDao.saveBranch(branch));
		return responseStructure;

	}
	
	
}
