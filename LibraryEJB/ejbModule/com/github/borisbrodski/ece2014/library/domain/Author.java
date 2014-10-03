package com.github.borisbrodski.ece2014.library.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.github.borisbrodski.ece2014.library.service.LibraryValidationException;

@Entity
public class Author extends AbstractEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private Date birthday;

	private Date dayOfDeath;
	
	@Override
	public void validate() throws LibraryValidationException {
		if (firstName == null) {
			throw new LibraryValidationException("first name can't be null");
		}
		if (lastName == null) {
			throw new LibraryValidationException("last name can't be null");
		}
		if (birthday == null) {
			throw new LibraryValidationException("birthday can't be null");
		}
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getDayOfDeath() {
		return dayOfDeath;
	}
	
	public void setDayOfDeath(Date dayOfDeath) {
		this.dayOfDeath = dayOfDeath;
	}
}
