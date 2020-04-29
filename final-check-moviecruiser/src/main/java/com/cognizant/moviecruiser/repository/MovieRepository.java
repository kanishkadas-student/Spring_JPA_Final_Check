package com.cognizant.moviecruiser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.moviecruiser.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository{
	
	@Query("select m from Movie m where m.active='true' and m.dateOfLaunch<= current_date()")
	public List<Movie> getAvailableMovie();
	
	
}
