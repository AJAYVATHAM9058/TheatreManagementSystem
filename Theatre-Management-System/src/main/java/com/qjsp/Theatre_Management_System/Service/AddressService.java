package com.qjsp.Theatre_Management_System.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qjsp.Theatre_Management_System.dao.AddressDao;
import com.qjsp.Theatre_Management_System.dto.Address;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@Service
public class AddressService {

	@Autowired
	AddressDao addressDao;

	@Autowired
	ResponseStructure<Address> responseStructure;

	@Autowired
	ResponseStructureList<Address> responseStructureList;

	public ResponseStructure<Address> saveAddress(Address address) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Address Data Inserted into DataBase");
		responseStructure.setData(addressDao.saveAddress(address));
		return responseStructure;
	}

	public ResponseStructure<Address> fetchAddressById(int addressId) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Address Data Retrieved from DataBase");
		responseStructure.setData(addressDao.fetchAddressById(addressId));
		return responseStructure;

	}

	public ResponseStructure<Address> deleteAddressById(int addressId) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Address Data Deleted From DataBase");
		responseStructure.setData(addressDao.deleteAddressById(addressId));
		return responseStructure;
	}

	public ResponseStructure<Address> updateAddressById(int addressId, Address address) {

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Address Data Updated From DataBase");
		responseStructure.setData(addressDao.updateAddressById(addressId, address));
		return responseStructure;
	}

	public ResponseStructureList<Address> fetchAll() {

		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("Successfully fetched all the Addresses from Database");
		responseStructureList.setData(addressDao.fetchAll());

		return responseStructureList;
	}

}
