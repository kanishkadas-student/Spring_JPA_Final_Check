package com.cognizant.moviecruiser.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.repository.MovieRepository;

@Service
public class MovieService {
	
	//private MovieDao movieDao;
	@Autowired
	private MovieRepository movieRepository;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(MovieService.class);
	
	
//	public void setMovieDao(MovieDao movieDao) {
//		this.movieDao = movieDao;
//	}
	
	public List<Movie> getMovieListAdmin(){
		//return movieDao.getMovieListAdmin();
		LOGGER.info("Start");
		return movieRepository.findAll();
		
	}
	
	public List<Movie> getMovieListCustomer(){
		//return movieDao.getMovieListCustomer();
		LOGGER.info("Start");
		return movieRepository.getAvailableMovie();
	}
	
	public Movie getMovie(long movieId) {
		//return movieDao.getMovie(movieId);
		LOGGER.info("Start");
		return (Movie) movieRepository.getOne(movieId);
	}
	
	public void modifyMovie(Movie movie){
		//movieDao.modifyMovie(movie);
		LOGGER.info("Start");
		movieRepository.save(movie);
		LOGGER.info("End");
	}
}
