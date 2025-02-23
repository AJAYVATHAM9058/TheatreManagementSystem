package com.qjsp.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qjsp.Theatre_Management_System.Exception.ManagerIdNotFound;
import com.qjsp.Theatre_Management_System.Repo.ManagerRepository;
import com.qjsp.Theatre_Management_System.dto.Manager;

@Repository
public class ManagerDao {

	@Autowired
	public ManagerRepository managerRepository;

	public Manager saveManager(Manager manager) {
		return managerRepository.save(manager);
	}

	public Manager fetchManagerById(int managerId) {
		Optional<Manager> optional = managerRepository.findById(managerId);
		if (optional.isEmpty()) {
			throw new ManagerIdNotFound("No Manager present with the given Id "+managerId);
		} else {

			return managerRepository.findById(managerId).get();
		}
	}

	public Manager deleteManagerById(int managerId) {
		Manager manager = fetchManagerById(managerId);
		managerRepository.delete(manager);
		return manager;

	}

	public Manager updateManagerById(int managerId, Manager manager) {
		fetchManagerById(managerId);
		manager.setManagerId(managerId);
		return saveManager(manager);

	}

	public List<Manager> fetchAll() {
		return managerRepository.findAll();
	}

}
