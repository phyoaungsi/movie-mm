package com.mmdrama.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.mmdrama.core.dao.CommonEntity;




@Entity
@Table( name = "LANGUAGE" )
public class Language extends CommonEntity {
	
	
    private String mmFont;
    private String enFont;

	public Language() {
		// this form used by Hibernate
	}
	
       
    public String getMmFont() {
		return mmFont;
    }

    public void setMmFont(String mmFont) {
		this.mmFont= mmFont;
    }
    
    public String getEnFont() {
		return enFont;
    }

    public void setEnFont(String enFont) {
		this.enFont= enFont;
    }

}
