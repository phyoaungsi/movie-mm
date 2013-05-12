package com.mmdrama.web.model.maintain.movie;

import java.io.File;
import java.math.BigDecimal;

public class MaintainMovie {
	
	private String name,embed,desc,map,uploadfileName;
	private BigDecimal latitude,longitude;
	private int zoomlevel;
	private File upload;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmbed() {
		return embed;
	}

	public void setEmbed(String embed) {
		this.embed = embed;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public String getUploadFileName() {
		return uploadfileName;
	}

	public File getUpload() {
		return upload;
	}

	public void setUploadFileName(String uploadfileName) {
		this.uploadfileName = uploadfileName;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public int getZoomlevel() {
		return zoomlevel;
	}

	public void setZoomlevel(int zoomlevel) {
		this.zoomlevel = zoomlevel;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

}
