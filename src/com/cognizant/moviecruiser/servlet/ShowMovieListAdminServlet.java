package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieListDao;
import com.cognizant.moviecruiser.dao.MovieListDaoCollectionImpl;
import com.cognizant.moviecruiser.model.MovieList;

/**
 * Servlet implementation class ShowMovieListAdminServlet
 */
@WebServlet("/ShowMovieListAdminServlet")
public class ShowMovieListAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMovieListAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MovieListDaoCollectionImpl movielistcollectionimpl = new MovieListDaoCollectionImpl();
		MovieListDao movielistdao = movielistcollectionimpl;
		movielistdao.getMovieListAdmin();
		List<MovieList> movieList=movielistdao.getMovieListAdmin();
		System.out.println("MenuItem.."+movieList);
		request.setAttribute("adminmovieList",movieList);
		request.getRequestDispatcher("movie-list-admin.jsp").forward(request, response);
	}

	

}
