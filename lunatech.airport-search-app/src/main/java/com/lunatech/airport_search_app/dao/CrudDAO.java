package com.lunatech.airport_search_app.dao;

import java.util.List;

import com.lunatech.airport_search_app.model.ModelObject;

/**
 * This interface defines the behavior a CRUD (Create Read Update Delete) dao
 * should be able to provide.
 */
public interface CrudDAO<T extends ModelObject>{


		/**
		 * Load the object.
		 * 
		 * @param stub
		 *            an object.
		 * @return the loaded object.
		 */
		T load(T stub);

		/**
		 * Save the object "obj".
		 * 
		 * @param obj
		 *            an object.
		 * @return the saved object.
		 */
		T save(T obj);

		/**
		 * Delete the object "obj".
		 * 
		 * @param obj
		 *            an object.
		 */
		void delete(T obj);

		/**
		 * 
		 * @return a list of all the objects.
		 */
		List<T> listAll();
	}
