package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieListDao;
import com.cognizant.moviecruiser.dao.MovieListDaoCollectionImpl;
import com.cognizant.moviecruiser.model.MovieList;

/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet("/EditMovieServlet")
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("movieid");
		System.out.println("ID: "+id);
        String title=request.getParameter("mname");
        System.out.println("name: "+title);
        String box_office=request.getParameter("price");
        System.out.println("price: "+box_office);
        boolean active=request.getParameter("active") != null;
        System.out.println("Active: "+active);
        String launchDate=request.getParameter("date");
        System.out.println("launch date: "+launchDate);
        String genre=request.getParameter("category");
        System.out.println("category: "+genre);
        boolean hasTeaser=request.getParameter("freedelivery") != null;
        System.out.println("freedelivery: "+hasTeaser);
        MovieList movieList=new MovieList();
        movieList.setActive(active);
        movieList.setBox_office(Long.parseLong(box_office));
        movieList.setId(Long.parseLong(id));
        movieList.setTitle(title);
        movieList.setHasTeaser(hasTeaser);
        movieList.setGenre(genre);
        Date d = null;

        SimpleDateFormat sdp=new SimpleDateFormat("dd/MM/yyyy");
        try
        {

        	d= sdp.parse(launchDate);
        	movieList.setDateOfLaunch(d);
        	MovieList movieList1=new MovieList(Long.parseLong(id),title,Long.parseLong(box_office),active,d,genre,hasTeaser);
        	MovieListDaoCollectionImpl movielistcollectionimpl = new MovieListDaoCollectionImpl();
    		MovieListDao movielistdao = movielistcollectionimpl;
    		movielistdao.modifyMovieList(movieList1);
        	System.out.println("Menuitem after updated is: "+movielistdao.getMovieListAdmin());
        	request.getRequestDispatcher("edit-movie-status.jsp").forward(request,response);
        }
        catch(Exception ex)
        {
        	ex.printStackTrace();
        }
	}

}
