package com.github.borisbrodski.ece2014.library.domain;

import javax.persistence.EntityManager;

import com.github.borisbrodski.ece2014.library.service.LibraryValidationException;
import com.github.borisbrodski.ece2014.library.tools.EntityManagerTool;


public abstract class AbstractEntity {

	public abstract Long getId();

	public void validate() throws LibraryValidationException {
	};

	public void persist() throws LibraryValidationException {
		validate();
		getEntityManager().persist(this);
	}

	public void refresh() {
		getEntityManager().refresh(this);
	}

	public void update() throws LibraryValidationException {
		validate();
	}
	
	public void remove() {
		getEntityManager().remove(this);
	}

	private EntityManager getEntityManager() {
		return EntityManagerTool.getEntityManager();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AbstractEntity)) {
			return false;
		}
		AbstractEntity entity = (AbstractEntity) obj;
		if (getId() == null && entity.getId() == null) {
			return super.equals(obj);
		}
		if (getId() == null || entity.getId() == null) {
			return false;
		}
		return getId().equals(entity.getId());
	}

	@Override
	public int hashCode() {
		if (getId() != null) {
			return getId().hashCode();
		}
		return super.hashCode();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "#" + getId();
	}
}
