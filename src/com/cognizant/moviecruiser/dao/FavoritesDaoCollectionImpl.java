/**
 * 
 */
package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.cognizant.moviecruiser.model.Favoriutes;
import com.cognizant.moviecruiser.model.MovieList;

/**
 * @Created By Saranya 760862
 *
 */
public class FavoritesDaoCollectionImpl implements FavoritesDao {
	private static HashMap<Long, Favoriutes> userFavorites;

	public FavoritesDaoCollectionImpl() {

		if (userFavorites == null) {
			userFavorites = new HashMap<Long, Favoriutes>();
			try {

				List<MovieList> movieList = new ArrayList<MovieList>();

				Favoriutes favorites = new Favoriutes(movieList, 0);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void addMovieList(long userId, long movieId) {
		// TODO Auto-generated method stub
		List<MovieList> movieList;
		MovieListDaoCollectionImpl movielistdaocollectionimpl = new MovieListDaoCollectionImpl();
		MovieListDao movieListDao = movielistdaocollectionimpl;
		// MenuItem mitem = menuItemDao.getMenuItem(menuItemId);
		Long userid = new Long(userId);
		MovieList menuItem = movieListDao.getMovie(movieId);
		if (userFavorites.containsKey(userId)) {
			Favoriutes favotites = userFavorites.get(userId);
			movieList = favotites.getMovieList();
			movieList.add(menuItem);
			favotites.setMovieList(movieList);
			// cart.setTotal(cart.getTotal() + menuItem.getPrice());
			userFavorites.put(userId, favotites);

		} else {
			movieList = new CopyOnWriteArrayList<MovieList>();
			movieList.add(menuItem);

			Favoriutes favorites = new Favoriutes(movieList, (int) menuItem.getId());
			userFavorites.put(userId, favorites);

		}

	}

	@Override
	public List<MovieList> getAllFavoritesItem(long userId)
			throws FavoritesEmptyException {
		// TODO Auto-generated method stub

		Favoriutes favorites = userFavorites.get(new Long(userId));
		List<MovieList> movieList = favorites.getMovieList();
		if (movieList == null || movieList.size() == 0) {
			throw new FavoritesEmptyException("Cart is empty");
		}
		int count = 0;
		for (MovieList menuItem : movieList) {
			count = count + 1;

		}
		favorites.setNoOffavorites(count);
		System.out.println(count);
		// TODO Auto-generated method stub
		return movieList;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cognizant.moviecruiser.dao.FavoritesDao#removeFavoritesItem(long,
	 * long)
	 */
	@Override
	public void removeFavoritesItem(long userId, long movieId) {
		// TODO Auto-generated method stub
		if (userFavorites.containsKey(userId)) {
			Favoriutes cart = userFavorites.get(userId);
			List<MovieList> movieList = cart.getMovieList();
			for (MovieList movieItem : movieList) {
				if (movieItem.getId() == movieId) {
					movieList.remove(movieItem);
				}
			}
			cart.setMovieList(movieList);
			userFavorites.put(userId, cart);

		}
	}

}
