package com.lunatech.airport_search_app.model;

import java.io.Serializable;
//import java.util.Observable;
//import java.util.UUID;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.ToStringBuilder;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class ModelObject implements Serializable{
	
	@Id
	@Column(name="ID")
	private Integer id; 				 // = UUID.randomUUID().toString(); //when we use event, we may need it. 
	
	public  Integer getId() { return id; }
	
	public void setId(Integer id2) {this.id = id2; }
	
	public String toString(){
		
		return ToStringBuilder.reflectionToString(this);
		
	}
	
	/*Easy ways to compare two values
	 * @param a the 1st object
	 * @param b the 2nd object
	 * @return true if a and b are equals (include both null case)
	 * */
	
	// The genericity is used here to force compiler to do the typecheck
	// not us.
	/*
	protected <A> boolean areNullSafeEquals(A a, A b)
	{
		//== is a reference comparison
		//both objects point to the same memory location
		if(a == b)
		{
			
			return true;
		}
		//.equals() evaluates to the value in the objects
		return (a!=null && a.equals(b));
	}
	
	/*
	public boolean equals(Object other) 
	{
		if((other instanceof ModelObject)) // 判断other 是不是 ModelObject 或子类的实例
		{
			return false;
		}
		ModelObject mdo = (ModelObject) other;
		return mdo.canEqual(this);
	}
	*/
	
	/*
	 * This method ensures the types of the two objects are
	 * compatible.
	 * */
	/*
	protected boolean canEqual(ModelObject mdo)
	{
		return mdo != null && getClass().isAssignableFrom(mdo.getClass());
	}
	*/
}
