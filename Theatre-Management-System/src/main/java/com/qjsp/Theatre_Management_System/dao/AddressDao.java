package com.qjsp.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qjsp.Theatre_Management_System.Exception.AddressIdNotFound;
import com.qjsp.Theatre_Management_System.Repo.AddressRepository;
import com.qjsp.Theatre_Management_System.dto.Address;

@Repository
public class AddressDao {

	@Autowired
	public AddressRepository addressRepository;

	public Address saveAddress(Address address) {
		return addressRepository.save(address);

	}

	public Address fetchAddressById(int addressId) {
		Optional<Address> optional = addressRepository.findById(addressId);
		if (optional.isEmpty()) {
			throw new AddressIdNotFound("No Address present with the given Id "+addressId);
		} else {

			return addressRepository.findById(addressId).get();
		}
	}

	public Address deleteAddressById(int addressId) {
		Address address = fetchAddressById(addressId);
		addressRepository.delete(address);
		return address;

	}

	public Address updateAddressById(int addressId, Address address) {
		fetchAddressById(addressId);
		address.setAddressId(addressId);
		return saveAddress(address);

	}

	public List<Address> fetchAll() {
		return addressRepository.findAll();
	}

}
