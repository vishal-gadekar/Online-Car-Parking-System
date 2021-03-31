package com.app.services;

import java.util.List;

import com.app.pojos.Place;

public interface IPlaceService {

	List<Place> allPlace();
	Place getPlaceDetails(int placeId);
	String deletePlace(int placeId);
	Place addPlace(Place p);
}
