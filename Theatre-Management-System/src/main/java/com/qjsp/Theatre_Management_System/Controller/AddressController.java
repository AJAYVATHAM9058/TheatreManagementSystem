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

import com.qjsp.Theatre_Management_System.Service.AddressService;
import com.qjsp.Theatre_Management_System.dto.Address;
import com.qjsp.Theatre_Management_System.util.ResponseStructure;
import com.qjsp.Theatre_Management_System.util.ResponseStructureList;

@RestController
@RequestMapping("address/api")
public class AddressController {

	@Autowired
	public AddressService addressService;
	
//	http://localhost:8080/address/api
	@PostMapping
	public ResponseStructure<Address> saveAddress(@RequestBody Address address) {
	
		return addressService.saveAddress(address);
	}
	
//	http://localhost:8080/address/api/8
	@GetMapping ("{addressId}")
	public ResponseStructure<Address> fetchAddressById(@PathVariable("addressId") int addressId) {
		
		return addressService.fetchAddressById(addressId);
	}
	
//	http://localhost:8080/address/api/8
	@DeleteMapping("{addressId}")
	public ResponseStructure<Address> deleteAddressById(@PathVariable("addressId") int addressId) {
		
		return addressService.deleteAddressById(addressId);
	}
	
//	http://localhost:8080/address/api?addressId=6
	@PutMapping
	public ResponseStructure<Address> updateAddressById(@RequestParam int addressId,@RequestBody Address address) {
		return addressService.updateAddressById(addressId, address);
	}
	
//	http://localhost:8080/address/api
	@GetMapping
	public ResponseStructureList<Address> fetchAll() {
		return addressService.fetchAll();
	}
	
}
