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
	public static void main(String[] args) throws FavoritesEmptyException{
		testAddMovieList();
		testRemoveCartItem();
		testGetAllFavotitesList();
		
	}
	
		static void testAddMovieList() throws FavoritesEmptyException
		{
			 FavoritesDaoCollectionImpl cartDaoCollectionImpl = new FavoritesDaoCollectionImpl();
		        FavoritesDao cartDao = cartDaoCollectionImpl;
		        cartDao.addMovieList(2,4);
		        cartDao.addMovieList(2,3);
		        List<MovieList> menuItemList = cartDao.getAllFavoritesItem(2);
		        System.out.println("MenuItem list :" + menuItemList);


		}
		static void testGetAllFavotitesList() throws FavoritesEmptyException
		{
			FavoritesDaoCollectionImpl  cartDaoCollectionImpl = new FavoritesDaoCollectionImpl();
			FavoritesDao cartDao = cartDaoCollectionImpl;
		    
		     List<MovieList> menuItemList = cartDao.getAllFavoritesItem(2);
		     System.out.println("MenuItem list :" + menuItemList);


		}
		static void testRemoveCartItem() throws FavoritesEmptyException
		{
			FavoritesDaoCollectionImpl cartDaoCollectionImpl = new FavoritesDaoCollectionImpl();
			FavoritesDao cartDao = cartDaoCollectionImpl;

	        try {
	        cartDao.removeFavoritesItem(2, 4);
	        List<MovieList> menuItemList = cartDao.getAllFavoritesItem(2);
	        System.out.println("MenuItem list after removed:" + menuItemList);
	        }
	        catch(Exception e){
	          throw new FavoritesEmptyException("Cart is empty");
	        }


	}
	}


