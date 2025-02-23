package com.qjsp.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qjsp.Theatre_Management_System.Exception.ViewerIdNotFound;
import com.qjsp.Theatre_Management_System.Repo.ViewerRepository;
import com.qjsp.Theatre_Management_System.dto.Viewer;

@Repository
public class ViewerDao {

	@Autowired
	public ViewerRepository viewerRepository;
	
	public Viewer saveViewer(Viewer viewer) {
		return viewerRepository.save(viewer);
	}
	
	public Viewer fetchViewerById(int viewerId) {
		Optional<Viewer> optional = viewerRepository.findById(viewerId);
		if(optional.isEmpty()) {
			throw new ViewerIdNotFound("No Viewer present with the given Id "+viewerId);
		}
		else {
			
			return viewerRepository.findById(viewerId).get();
		}
	}

	public Viewer deleteViewerById(int viewerId) {
		Viewer viewer = fetchViewerById(viewerId);
		viewerRepository.delete(viewer);
		return viewer;

	}

	public Viewer updateViewerById(int viewerId, Viewer viewer) {
		fetchViewerById(viewerId);
		viewer.setViewerId(viewerId);
		return saveViewer(viewer);

	}
	
	public List<Viewer> fetchAll(){
		return viewerRepository.findAll();
	}
}
