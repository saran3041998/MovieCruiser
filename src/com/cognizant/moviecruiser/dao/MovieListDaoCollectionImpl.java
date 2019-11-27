/**
 * 
 */
package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieList;
import com.cognizant.moviecruiser.util.DateUtil;

/**
 * @Created By Saranya 760862
 *
 */
public class MovieListDaoCollectionImpl implements MovieListDao {

	static List<MovieList> movieList;

	public MovieListDaoCollectionImpl() {
		if (movieList == null) {
			try {
				movieList = new ArrayList<MovieList>();
				movieList.add(new MovieList(0000001, "Avatar", 278796508, true,
						DateUtil.convertToDate("28/09/1997"),
						"Science Fiction", true));
				movieList.add(new MovieList(0000002, "The Avengers",
						1518812988, true, DateUtil.convertToDate("18/04/1996"),
						"Superhero", false));
				movieList.add(new MovieList(0000003, "Titanic", 1187463944,
						true, DateUtil.convertToDate("23/07/1996"), "Romance",
						false));
				movieList.add(new MovieList(0000004, "Jurassic World",
						1671713208, true, DateUtil.convertToDate("08/01/1996"),
						"Science Fiction", true));
				movieList.add(new MovieList(0000005, "Avengers: End Game",
						275076034, true, DateUtil.convertToDate("02/04/1996"),
						"Superhero", true));
			} catch (ParseException e) {
				System.out.println(e);
			}
		}

	}

	@Override
	public List<MovieList> getMovieListAdmin() {
		// TODO Auto-generated method stub
		return movieList;
	}

	@Override
	public List<MovieList> getMovieItemlistCustomer() {
		// TODO Auto-generated method stub
		List<MovieList> mlistcus = new ArrayList<MovieList>();
		Date today = new Date();
		for (MovieList movielist : movieList) {
			if (movielist.getDateOfLaunch().getTime() <= today.getTime()
					&& movielist.isActive()) {
				mlistcus.add(movielist);
			}
		}
		return mlistcus;
	}

	@Override
	public void modifyMovieList(MovieList movie) {
		// TODO Auto-generated method stub
		for (MovieList movie_modify : movieList) {
			if (movie.getId() == movie_modify.getId()) {
				movie_modify.setTitle(movie.getTitle());
				movie_modify.setGenre(movie.getGenre());
				movie_modify.setBox_office(movie.getBox_office());
				movie_modify.setHasTeaser(movie.getHasTeaser());
				movie_modify.setActive(movie.isActive());
				movie_modify.setDateOfLaunch(movie.getDateOfLaunch());

			}
		}

	}

	@Override
	public MovieList getMovie(long id) {
		// TODO Auto-generated method stub
		for (MovieList movie_list : movieList) {
			if (id == movie_list.getId()) {
				return movie_list;
			}
		}

		return null;

	}

}
