package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {

}
