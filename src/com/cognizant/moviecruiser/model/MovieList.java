/**
 * 
 */
package com.cognizant.moviecruiser.model;

import java.util.Date;

/**
 * @Created By Saranya 760862
 *
 */
public class MovieList {
	
	private long id;
	/**
	 * @param id
	 * @param title
	 * @param box_office
	 * @param active
	 * @param dateOfLaunch
	 * @param genre
	 * @param hasTeaser
	 */
	public MovieList(long id, String title, long box_office, boolean active,
			Date dateOfLaunch, String genre, boolean hasTeaser) {
		super();
		this.id = id;
		this.title = title;
		this.box_office = box_office;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.genre = genre;
		this.hasTeaser = hasTeaser;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	private String title;
	
	private long box_office;
	private boolean active;
	private Date dateOfLaunch;
	private String genre;
	private boolean hasTeaser;
	/**
	 * @param title
	 * @param box_office
	 * @param active
	 * @param dateOfLaunch
	 * @param genre
	 * @param hasTeaser
	 */
	
	@Override
	public String toString() {
		return "MovieList [id=" + id + ", title=" + title + ", box_office="
				+ box_office + ", active=" + active + ", dateOfLaunch="
				+ dateOfLaunch + ", genre=" + genre + ", hasTeaser="
				+ hasTeaser + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(box_office);
		result = prime * result
				+ ((dateOfLaunch == null) ? 0 : dateOfLaunch.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + (hasTeaser ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	/**
	 * @param hasTeaser the hasTeaser to set
	 */
	public void setHasTeaser(boolean hasTeaser) {
		this.hasTeaser = hasTeaser;
	}
	/* (non-Javadoc)
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
		MovieList other = (MovieList) obj;
		if (active != other.active)
			return false;
		if (Float.floatToIntBits(box_office) != Float
				.floatToIntBits(other.box_office))
			return false;
		if (dateOfLaunch == null) {
			if (other.dateOfLaunch != null)
				return false;
		} else if (!dateOfLaunch.equals(other.dateOfLaunch))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (hasTeaser != other.hasTeaser)
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	/**
	 * @param title
	 * @param box_office
	 * @param active
	 * @param dateOfLaunch
	 * @param genre
	 * @param hasTeaser
	 */
	
	/**
	 * @return the title
	 */
	public  String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the box_office
	 */
	public long getBox_office() {
		return box_office;
	}
	/**
	 * @param f the box_office to set
	 */
	public void setBox_office(long f) {
		this.box_office = f;
	}
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	/**
	 * @return the dateOfLaunch
	 */
	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}
	/**
	 * @param dateOfLaunch the dateOfLaunch to set
	 */
	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}
	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * @return the hasTeaser
	 */
	public Boolean getHasTeaser() {
		return hasTeaser;
	}
	/**
	 * @param hasTeaser the hasTeaser to set
	 */
	public void setHasTeaser(Boolean hasTeaser) {
		this.hasTeaser = hasTeaser;
	}
	/**
	 * @return
	 */

}
