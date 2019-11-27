/**
 * 
 */
package com.cognizant.moviecruiser.model;

import java.util.List;

/**
 * @Created By Saranya 760862
 *
 */
public class Favoriutes {
	private List<MovieList> movieList;
	private int noOffavorites;

	/**
	 * @return the movieList
	 */
	public List<MovieList> getMovieList() {
		return movieList;
	}

	/**
	 * @param movieList
	 * @param noOffavorites
	 */
	public Favoriutes(List<MovieList> movieList, int noOffavorites) {
		super();
		this.movieList = movieList;
		this.noOffavorites = noOffavorites;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Favoriutes [movieList=" + movieList + ", noOffavorites="
				+ noOffavorites + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((movieList == null) ? 0 : movieList.hashCode());
		result = prime * result + noOffavorites;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favoriutes other = (Favoriutes) obj;
		if (movieList == null) {
			if (other.movieList != null)
				return false;
		} else if (!movieList.equals(other.movieList))
			return false;
		if (noOffavorites != other.noOffavorites)
			return false;
		return true;
	}

	/**
	 * @param movieList
	 *            the movieList to set
	 */
	public void setMovieList(List<MovieList> movieList) {
		this.movieList = movieList;
	}

	/**
	 * @return the noOffavorites
	 */
	public int getNoOffavorites() {
		return noOffavorites;
	}

	/**
	 * @param noOffavorites
	 *            the noOffavorites to set
	 */
	public void setNoOffavorites(int noOffavorites) {
		this.noOffavorites = noOffavorites;
	}

}
