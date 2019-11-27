/**
 * 
 */
package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.MovieList;

/**
 * @Created By Saranya 760862
 *
 */
public interface MovieListDao {
	List<MovieList> getMovieListAdmin();

	List<MovieList> getMovieItemlistCustomer();

	void modifyMovieList(MovieList movieList);

	MovieList getMovie(long id);

}
