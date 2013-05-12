package com.mmdrama.constants;

public enum PropertyKey {
	
	IMAGE_PATH("image.path"),
	YOUTUBE_EMBED("youtube.embed"),
	U2_THUMBNAIL_URL("youtube.thumbnail.url");
	String name;
	PropertyKey(String name)
	{
		
		this.name=name;
	}

	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
}
