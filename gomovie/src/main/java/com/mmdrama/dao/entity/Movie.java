package com.mmdrama.dao.entity;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mmdrama.core.dao.CommonEntity;

@Entity
@Table( name = "MOVIE" )
@DiscriminatorValue("Movie")
public class Movie extends CommonEntity {
   
     @Column(unique = true)
    private String title;
     
    private Date date;

    @Column
    private String link;
    
    @Column
    private String thumbnail;
    
    @Column
    private String description;
    
    @Column
    private String embed;
    
    @Column
    private int rank;
    
    @Column
    private boolean featured;
    
    @Column
    private String backgroundImage;
    
    @OneToOne(optional=true,cascade = CascadeType.ALL)
    private GoogleMap map;
    
    
 
    
//
//	 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinTable(name = "MOVIE_ACTOR", joinColumns = {@JoinColumn(name = "uuid_actor", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "uuid_movie", nullable = false, updatable = false) })
//    private Set<Actor> actors;
//    
	public Movie() {
		// this form used by Hibernate
	}

	public Movie(String title, Date date) {
		// for application use, to create new events
		this.title = title;
		this.date = date;
	}


	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EVENT_DATE")
    public Date getDate() {
		return date;
    }

    public void setDate(Date date) {
		this.date = date;
    }

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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public GoogleMap getMap() {
		return map;
	}

	public void setMap(GoogleMap map) {
		this.map = map;
	}

	public String getEmbed() {
		return embed;
	}

	public void setEmbed(String embed) {
		this.embed = embed;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public boolean isFeatured() {
		return featured;
	}

	public void setFeatured(boolean featured) {
		this.featured = featured;
	}

	public String getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(String backgroundImage) {
		this.backgroundImage = backgroundImage;
	}




//	public Set<Actor> getActors() {
//		return actors;
//	}
//
//	public void setActors(Set<Actor> actors) {
//		this.actors = actors;
//	}
}