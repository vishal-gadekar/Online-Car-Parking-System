package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exc.ResourceNotFoundException;
import com.app.pojos.Place;
import com.app.repository.PlaceRepository;

@Service
@Transactional
public class PlaceServiceImpl implements IPlaceService {
	@Autowired
	PlaceRepository placeRepo;	
	
	@Override 
	public List<Place> allPlace() {
	  
		return placeRepo.findAll(); 
	} 
	 

	@Override
	public Place getPlaceDetails(int placeId) {
		Place p= placeRepo.findById(placeId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Place Id"));
		return p;
	}

	@Override
	public String deletePlace(int placeId) {
		Place place = placeRepo.findById(placeId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Place ID"));
		placeRepo.delete(place);
		return "Place details for ID "+placeId+" deleted...";
	}

	@Override
	public Place addPlace(Place p) {
		placeRepo.save(p);
		return p;
	}
	

}
