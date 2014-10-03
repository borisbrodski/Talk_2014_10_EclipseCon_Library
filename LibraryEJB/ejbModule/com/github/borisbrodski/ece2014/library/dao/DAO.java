package com.github.borisbrodski.ece2014.library.dao;

import com.github.borisbrodski.ece2014.library.domain.AbstractEntity;
import com.github.borisbrodski.ece2014.library.tools.EntityManagerTool;

public class DAO {
	@SuppressWarnings("unchecked")
	public static <T extends AbstractDAO<? extends AbstractEntity>> T get(
			Class<T> clazz) {
		try {
			String implClassName = clazz.getName() + "Impl";
			Class<?> implClass = Class.forName(implClassName);
			return (T) implClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(
					"Error instanciating DAO implementation for "
							+ clazz.getName(), e);
		}
	}

	public static <T> T getEntity(Class<T> clazz, Long id) {
		return EntityManagerTool.getEntityManager().find(clazz, id);
	}

}