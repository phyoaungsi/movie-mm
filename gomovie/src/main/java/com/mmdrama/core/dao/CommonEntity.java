package com.mmdrama.core.dao;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@MappedSuperclass
public class CommonEntity {

	@Id
	@Column(nullable=false, length=64)
	private String uuid;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date createdTime;
	
	
	   @Column
	    private String tags;
	    
	    @Column
	    private String metadata;
	    
	    @Column
	    private String json;
	    
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Date getCreatedTime() {
		return new Date();
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@PrePersist
	private void setUp()
	{
		this.createdTime=new Date();
		this.uuid= UUID.randomUUID().toString();
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getMetadata() {
		return metadata;
	}
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
}
