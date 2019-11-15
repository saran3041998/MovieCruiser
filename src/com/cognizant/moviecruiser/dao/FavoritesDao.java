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
public interface FavoritesDao {
	void addMovieList(long userId,long movieId);
	List<MovieList> getAllFavoritesItem(long userId) throws FavoritesEmptyException;
	void removeFavoritesItem(long userId,long movieId);

}
