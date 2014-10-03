package com.github.borisbrodski.ece2014.library.service;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class LibraryValidationException extends Exception {
	private static final long serialVersionUID = 42L;

	public LibraryValidationException(String string) {
		super(string);
	}
}
