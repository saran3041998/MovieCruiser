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
public class FavoritesDaoCollectionImplTest {
	public static void main(String[] args) throws FavoritesEmptyException {
		testAddMovieList();
		testRemoveCartItem();
		testGetAllFavotitesList();

	}

	static void testAddMovieList() throws FavoritesEmptyException {
		FavoritesDaoCollectionImpl favoritesDaoCollectionImpl = new FavoritesDaoCollectionImpl();
		FavoritesDao favoritesDao = favoritesDaoCollectionImpl;
		favoritesDao.addMovieList(2, 4);
		favoritesDao.addMovieList(2, 3);
		List<MovieList> menuItemList = favoritesDao.getAllFavoritesItem(2);
		System.out.println("MenuItem list :" + menuItemList);

	}

	static void testGetAllFavotitesList() throws FavoritesEmptyException {
		FavoritesDaoCollectionImpl favoritesDaoCollectionImpl= new FavoritesDaoCollectionImpl();
		FavoritesDao favoritesDao = favoritesDaoCollectionImpl;

		List<MovieList> menuItemList = favoritesDao.getAllFavoritesItem(2);
		System.out.println("MenuItem list :" + menuItemList);

	}

	static void testRemoveCartItem() throws FavoritesEmptyException {
		FavoritesDaoCollectionImpl favoritesDaoCollectionImpl = new FavoritesDaoCollectionImpl();
		FavoritesDao favoritesDao = favoritesDaoCollectionImpl;

		try {
			favoritesDao.removeFavoritesItem(2, 4);
			List<MovieList> menuItemList = favoritesDao.getAllFavoritesItem(2);
			System.out.println("MenuItem list after removed:" + menuItemList);
		} catch (Exception e) {
			throw new FavoritesEmptyException("Cart is empty");
		}

	}
}
