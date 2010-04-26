package org.stripesbook.quickstart.action;

import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.stripesbook.quickstart.model.Image;
import org.stripesbook.quickstart.model.Location;
import org.stripesbook.quickstart.model.Person;
import org.stripesbook.quickstart.model.TrackableItem;

@UrlBinding("/Home.action")
public class HomeActionBean extends BaseActionBean {
		
	private static final String RESULT = "/WEB-INF/jsp/result.jsp";

	private Session sess = org.stripesbook.quickstart.util.DAO.getSession();
    private Criteria critPerson = sess.createCriteria(Person.class);
    private Criteria critItem = sess.createCriteria(TrackableItem.class);
    private Criteria critLocation = sess.createCriteria(Location.class);
    private Criteria critImage = sess.createCriteria(Image.class);
    
	private List<Person> personsList;
	private List<TrackableItem> itemsList;
	private List<Location> locationsList;
	private List<Image> imagesList;

    @DefaultHandler
    public Resolution view() {
    	populatePersonsList();
    	populateItemsList();
    	populateLocationsList();
    	populateImagesList();
        return new ForwardResolution("/WEB-INF/jsp/home.jsp");
    }        
    
    public void populatePersonsList() {        
        logger.debug("populate Person list");
        sess.createCriteria(Person.class);
        critPerson.addOrder(Order.asc("firstName"));
        personsList = critPerson.list();        
    }
    public void populateItemsList() {        
        logger.debug("populate items list");
        sess.createCriteria(TrackableItem.class);
        critItem.addOrder(Order.asc("name"));
        itemsList = critItem.list();        
    }
    public void populateLocationsList() {        
        logger.debug("populate locations list");
        sess.createCriteria(Location.class);
        critLocation.addOrder(Order.asc("name"));
        locationsList = (List<Location>) critLocation.list();        
    }
    public void populateImagesList() {        
        logger.debug("populate images list");
        sess.createCriteria(Image.class);
        critLocation.addOrder(Order.asc("title"));
        imagesList = (List<Image>) critImage.list();        
    }
    public List<Person> getPersonsList() {
        return personsList;
    }

    public void setPersonsList(List<Person> personsList) {
        this.personsList = personsList;
    }

	public void setItemsList(List<TrackableItem> itemsList) {
		this.itemsList = itemsList;
	}

	public List<TrackableItem> getItemsList() {
		return itemsList;
	}

    public List<Location> getLocationsList() {
        return locationsList;
    }

    public void setLocationsList(List<Location> locationsList) {
        this.locationsList = locationsList;
    }

	public List<Image> getImagesList() {
		return imagesList;
	}

	public void setImagesList(List<Image> imagesList) {
		this.imagesList = imagesList;
	}
}