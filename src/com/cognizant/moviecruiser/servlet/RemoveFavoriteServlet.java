package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavoritesDao;
import com.cognizant.moviecruiser.dao.FavoritesDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.FavoritesEmptyException;
import com.cognizant.moviecruiser.dao.MovieListDao;
import com.cognizant.moviecruiser.dao.MovieListDaoCollectionImpl;
import com.cognizant.moviecruiser.model.MovieList;

/**
 * Servlet implementation class RemoveFavoriteServlet
 */
@WebServlet("/RemoveFavoriteServlet")
public class RemoveFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFavoriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        long userId=1;
		
		String id=request.getParameter("id");
		int movieId=Integer.parseInt(id);
		FavoritesDaoCollectionImpl favoritesDaoCollectionImpl = new FavoritesDaoCollectionImpl();
		FavoritesDao favoritesDao = favoritesDaoCollectionImpl;
		MovieListDaoCollectionImpl movielistcollectionimpl = new MovieListDaoCollectionImpl();
		MovieListDao movielistdao = movielistcollectionimpl;
		favoritesDao.removeFavoritesItem(1, movieId);
		try {
			List<MovieList> movieList = favoritesDao.getAllFavoritesItem(userId);
			 request.setAttribute("removeFavotiteStatus",true);
		        //request.setAttribute("removeMenuItemList", menuItemList);
		        request.setAttribute("customermovieList", movieList);
		        request.getRequestDispatcher("favorites.jsp").forward(request,response);
		} catch (FavoritesEmptyException e) {
			// TODO Auto-generated catch block
			request.getRequestDispatcher("favorites-empty.jsp").forward(request,response);
			
		}
		
	}

	

}
