package com.mmdrama.dao.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mmdrama.core.dao.CommonEntity;

@Entity
@Table( name = "GOOGLE_MAP" )
public class GoogleMap extends CommonEntity{
	@Column
	public BigDecimal lattitude;
	@Column
	public BigDecimal longitude;
	@Column
	public int zoomLevel;
	
	public BigDecimal getLattitude() {
		return lattitude;
	}
	public void setLattitude(BigDecimal lattitude) {
		this.lattitude = lattitude;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public int getZoomLevel() {
		return zoomLevel;
	}
	public void setZoomLevel(int zoomLevel) {
		this.zoomLevel = zoomLevel;
	}

}
