package com.mmdrama.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mmdrama.core.dao.CommonEntity;
@Entity
@Table( name = "RSS_FEEDS" )
public class RssFeeds extends CommonEntity {

	@Column
	public String title;
	@Column
	public String link;
	@Column
	public String description;
	@Column
	public Date pubDate;
	@Column
	public String guid;
	@Column
	public String aurthor;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getAurthor() {
		return aurthor;
	}
	public void setAurthor(String aurthor) {
		this.aurthor = aurthor;
	}
	
	  

   

	
	
}
