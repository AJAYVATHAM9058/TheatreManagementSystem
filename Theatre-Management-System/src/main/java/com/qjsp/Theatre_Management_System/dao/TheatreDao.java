package com.qjsp.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qjsp.Theatre_Management_System.Exception.TheatreIdNotFound;
import com.qjsp.Theatre_Management_System.Repo.TheatreRepo;
import com.qjsp.Theatre_Management_System.dto.Theatre;

@Repository
public class TheatreDao {

	@Autowired
	public TheatreRepo theatreRepository;
	
	public Theatre saveTheatre(Theatre theatre) {
		
		return theatreRepository.save(theatre);

	}
	
	public Theatre fetchTheatreById(int theatreId) {
		Optional<Theatre> optional = theatreRepository.findById(theatreId);
		if(optional.isEmpty()) {
			throw new TheatreIdNotFound("No Theatre present with the given Id "+theatreId);
		}
		else {
			
			return theatreRepository.findById(theatreId).get();
		}
	}
	
	public Theatre deleteTheatreById(int id) {
		Theatre theatre = fetchTheatreById(id);
		theatreRepository.delete(theatre);
		return theatre;
	}
	
	public List<Theatre> fetchAll(){
		return theatreRepository.findAll();
	}
	
	public Theatre updateTheatre(int theatreId,Theatre theatre) {
		
		Theatre oldTheatre = fetchTheatreById(theatreId);
		oldTheatre.setTheatreEmail(theatre.getTheatreEmail());
		oldTheatre.setTheatreGst(oldTheatre.getTheatreGst());
		oldTheatre.setTheatreName(theatre.getTheatreName());
		oldTheatre.setTheatrePhone(theatre.getTheatrePhone());
		
		return saveTheatre(oldTheatre);
	}
	
}
