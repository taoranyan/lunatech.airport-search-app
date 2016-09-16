package com.lunatech.airport_search_app.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.lunatech.airport_search_app.dao.CrudDAO;
import com.lunatech.airport_search_app.model.ModelObject;

public abstract class AbstractCrudDAOImpl<T extends ModelObject> implements CrudDAO<T> {
	
	@PersistenceContext(unitName="AIRPORT-SEARCH-APP")
	private EntityManager em;
	
	@Transactional
	public T save(final T obj){
		if(obj==null){ return obj; }
		T ret = obj;
		if(exists(obj)){
			ret = em.merge(obj);
		} else {
			em.persist(obj);
		}
		return ret;
	}
	
	@Transactional
	public void delete(final T obj) {
		if(obj==null){return;}
		T managed = em.merge(obj);
		em.remove(managed);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public T load(T stub){
		if(stub==null){return null;}
		return (T) em.find(stub.getClass(), stub.getId());
	}

	public boolean exists(final T obj){
		if(obj==null){ return false; }
		return em.find(obj.getClass(), obj.getId())!=null;
	}
	
	public Query createQuery(String query){
		return em.createQuery(query);
	}
	
	public EntityManager getEntityManager(){
		return em;
	}
}

