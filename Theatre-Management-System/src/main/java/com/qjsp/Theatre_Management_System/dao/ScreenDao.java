package com.qjsp.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qjsp.Theatre_Management_System.Exception.ScreenIdNotFound;
import com.qjsp.Theatre_Management_System.Repo.ScreenRepository;
import com.qjsp.Theatre_Management_System.dto.Screen;

@Repository
public class ScreenDao {

	@Autowired
	public ScreenRepository screenRepository;
	
	public Screen saveScreen(Screen screen) {
		return screenRepository.save(screen);
	}
	
	public Screen fetchScreenById(int screenId) {
		Optional<Screen> optional = screenRepository.findById(screenId);
		if(optional.isEmpty()) {
			throw new ScreenIdNotFound("No Screen present with the given Id "+screenId);
		}
		else {
			
			return screenRepository.findById(screenId).get();
		}
	}

	public Screen deleteScreenById(int screenId) {
		Screen screen = fetchScreenById(screenId);
		screenRepository.delete(screen);
		return screen;

	}

	public Screen updateScreenById(int screenId, Screen screen) {
		fetchScreenById(screenId);
		screen.setScreenId(screenId);
		return saveScreen(screen);

	}
	
	public List<Screen> fetchAll(){
		return screenRepository.findAll();
	}
	
	
}
