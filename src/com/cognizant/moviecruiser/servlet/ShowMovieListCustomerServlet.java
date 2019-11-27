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
 * Servlet implementation class ShowMovieListCustomerServlet
 */
@WebServlet("/ShowMovieListCustomerServlet")
public class ShowMovieListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMovieListCustomerServlet() {
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
		movielistdao.getMovieItemlistCustomer();
		List<MovieList> movieList=movielistdao.getMovieItemlistCustomer();
		System.out.println("Customer list .."+movieList);
		request.setAttribute("customermovieList",movieList);
		request.getRequestDispatcher("movie-list-customer.jsp").forward(request, response);
	}

	

}
