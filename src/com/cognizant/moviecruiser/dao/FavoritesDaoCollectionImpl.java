/**
 * 
 */
package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

                      List<MovieList> movieList= new ArrayList<MovieList>();

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
        MovieListDaoCollectionImpl menuItemDaoCollectionImpl = new MovieListDaoCollectionImpl();
        MovieListDao menuItemDao = menuItemDaoCollectionImpl;
        // MenuItem mitem = menuItemDao.getMenuItem(menuItemId);
        Long userid = new Long(userId);
        MovieList menuItem = menuItemDao.getMovie(movieId);
        if (userFavorites.containsKey(userId)) {
        	Favoriutes cart = userFavorites.get(userId);
              movieList = cart.getMovieList();
             movieList.add(menuItem);
              cart.setMovieList(movieList);
              // cart.setTotal(cart.getTotal() + menuItem.getPrice());
              userFavorites.put(userId, cart);

        } else {
              movieList = new ArrayList<MovieList>();
              movieList.add(menuItem);

              Favoriutes cart = new Favoriutes(movieList, (int)menuItem.getId());
              userFavorites.put(userId, cart);

        }
		
	}

	
	@Override
	public List<MovieList> getAllFavoritesItem(long userId)
			throws FavoritesEmptyException {
		// TODO Auto-generated method stub

		Favoriutes cart = userFavorites.get(new Long(userId));
        List<MovieList> menuItemList = cart.getMovieList();
        if (menuItemList == null || menuItemList.size() == 0) {
              throw new FavoritesEmptyException("Cart is empty");
        }
     int count=0;
        for (MovieList menuItem : menuItemList) {
             count=count+1;

        }
        cart.setNoOffavorites(count);
        System.out.println(count);
        // TODO Auto-generated method stub
        return menuItemList;

	}

	/* (non-Javadoc)
	 * @see com.cognizant.moviecruiser.dao.FavoritesDao#removeFavoritesItem(long, long)
	 */
	@Override
	public void removeFavoritesItem(long userId, long movieId) {
		// TODO Auto-generated method stub
		if (userFavorites.containsKey(userId)) {
			Favoriutes cart = userFavorites.get(userId);
            List<MovieList> menuItemList = cart.getMovieList();
            for (MovieList menuItem : menuItemList) {
                  if (menuItem.getId() == movieId) {
                        menuItemList.remove(menuItem);
                  }
            }
            cart.setMovieList(menuItemList);
            userFavorites.put(userId, cart);
            
      }
}
		
	}

	
	

