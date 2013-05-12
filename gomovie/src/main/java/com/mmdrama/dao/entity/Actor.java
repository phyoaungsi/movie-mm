/**
 * 
 */
package com.mmdrama.dao.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.mmdrama.core.dao.CommonEntity;

/**
 * @author nilar_thein
 *
 */

@Entity
@Table(name = "ACTOR" )
public class Actor extends CommonEntity {
	
	@Column
    private String name;
	
//	 @ManyToMany(fetch = FetchType.LAZY, mappedBy = "actors")
//    private Set<Movie> movies=new HashSet<Movie>();
//	
	
	public Actor() {
		// this form used by Hibernate
	}
	
   
    
    public String getName() {
		return name;
    }

    public void setName(String name) {
		this.name= name;
    }



}
