package org.stripesbook.quickstart.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class TrackableItem extends ModelBase {

	private String name;
	private String description;
	private String url;
	private String lookupUrl;
	
	@OneToOne
	private Person creator;
	
	@ManyToOne
	private Person owner;
	
	@OneToOne
	private Location location;
	
	@OneToMany
	private Collection<Image> images;
	
	private Date created;
	private Date updated;
	
	public TrackableItem() {
		this.created = new Date();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLookupUrl() {
		return lookupUrl;
	}
	public void setLookupUrl(String lookupUrl) {
		this.lookupUrl = lookupUrl;
	}
	public Person getCreator() {
		return creator;
	}
	public void setCreator(Person creator) {
		this.creator = creator;
	}
	public Person getOwner() {
		return owner;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Collection<Image> getImages() {
        return images;
    }

    public void setImages(Collection<Image> images) {
        this.images = images;
    }

    public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
}