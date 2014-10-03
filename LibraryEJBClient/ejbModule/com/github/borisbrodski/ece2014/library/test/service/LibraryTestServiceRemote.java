package com.github.borisbrodski.ece2014.library.test.service;

import javax.ejb.Remote;

@Remote
public interface LibraryTestServiceRemote {

	/**
	 * Return highest rating present in the DB.
	 * @return highest rating
	 */
	Integer getMaxRating();

}
