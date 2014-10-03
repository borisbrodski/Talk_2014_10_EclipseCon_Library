package com.github.borisbrodski.ece2014.library.service;

import java.util.Date;

public class AuthorDTO extends AbstractDTO {
	private static final long serialVersionUID = 42L;

	private Long id;

	private String lastName;

	private String firstName;

	private Date birthday;
	
	private Date dayOfDeath;

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
