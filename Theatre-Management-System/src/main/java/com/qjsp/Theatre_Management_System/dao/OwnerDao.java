package com.qjsp.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qjsp.Theatre_Management_System.Exception.OwnerIdNotFound;
import com.qjsp.Theatre_Management_System.Repo.OwnerRepository;
import com.qjsp.Theatre_Management_System.dto.Owner;

@Repository
public class OwnerDao {

	@Autowired
 	public OwnerRepository ownerRepository;
	
	public Owner saveOwner(Owner owner) {
		
		return ownerRepository.save(owner);
	}
	
	public Owner deleteOwnerById(int ownerId) {
		Owner owner = fetchOwnerById(ownerId);
		ownerRepository.delete(owner);
		return owner;
	}
	
	public Owner fetchOwnerById(int ownerId) {
		
		Optional<Owner> optional = ownerRepository.findById(ownerId);
		if(optional.isEmpty()) {
			throw new OwnerIdNotFound("No Owner present with the given Id "+ownerId);
		}
		else {
			
			return ownerRepository.findById(ownerId).get();
		}
		
	}
	
	public Owner updateOwnerById(int oldId,Owner owner) {
		fetchOwnerById(oldId);
		owner.setOwnerId(oldId);
		return saveOwner(owner);
	}
	
	public List<Owner> fetchAll(){
		return ownerRepository.findAll();
	}
	
	
	
}
