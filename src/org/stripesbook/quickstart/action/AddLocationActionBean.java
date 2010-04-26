package org.stripesbook.quickstart.action;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.stripesbook.quickstart.model.Location;
import org.stripesbook.quickstart.model.Person;
import org.stripesbook.quickstart.model.TrackableItem;
import org.stripesstuff.stripersist.Stripersist;

@UrlBinding("/AddLocation.action")
public class AddLocationActionBean extends BaseActionBean {
		
	private static final String RESULT = "/WEB-INF/jsp/addLocationResult.jsp";
	private Session sess = org.stripesbook.quickstart.util.DAO.getSession();
    private Criteria crit = sess.createCriteria(Location.class);
    private Criteria critPerson = sess.createCriteria(Person.class);
    private Criteria critItem = sess.createCriteria(TrackableItem.class);
    
    private Integer personId;
    private Person person;
    private Integer itemId;
	private Location location;
	private List<Location> locationsList;
	
    @DefaultHandler
    public Resolution view() {
    	
    	if ( personId != null ) {
    		
    	}
    	
        return new ForwardResolution("/WEB-INF/jsp/addLocation.jsp");
    }
        
    public Resolution newLocation() {
    	
    	EntityManager em = Stripersist.getEntityManager();
    		
    	try {        	
        	if (logger.isDebugEnabled()) {
        		logger.debug("location.id          : " + location.getId());
        		logger.debug("location.name        : " + location.getName());
        		logger.debug("location.streetAdd1  : " + location.getStreetAddress1());
        		logger.debug("location.streetAdd2  : " + location.getStreetAddress2());
        		logger.debug("location.city        : " + location.getCity());
        		logger.debug("location.state       : " + location.getState());
        		logger.debug("location.postalCode  : " + location.getPostalCode());
        		logger.debug("location.logitude    : " + location.getLongitude());
        		logger.debug("location.latitide    : " + location.getLatitude());
        	}        	

        	em.persist(location);
    		em.getTransaction().commit();
    		logger.debug("committed location");
    		
    		if( personId != null ) {
    			logger.debug("This is an attempt to add and address to person id:" + personId);
        		Person person = em.find(Person.class, personId);
        		person.setAddress(location);
        		em.persist(person);
        		em.persist(person.getAddress());
        		logger.debug("committed person");        			
        	}
    		if( itemId != null ) {
        		TrackableItem item = em.find(TrackableItem.class, itemId);
        		item.setLocation(location);
        		em.persist(item);
        		logger.debug("committed item");        			
        	}

    	} catch (EntityExistsException eee) {
    		em.getTransaction().rollback();
    		eee.printStackTrace();
    	}
    	
    	populateList();
    	return new ForwardResolution(RESULT);
    }
    
    public void populateList() {        
        logger.debug("populate Location list");
        sess.createCriteria(Location.class);
        crit.addOrder(Order.asc("name"));
        locationsList = crit.list();                
    }
    
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
    public List<Location> getLocationsList() {
        return locationsList;
    }
    public void setLocationsList(List<Location> locationsList) {
        this.locationsList = locationsList;
    }
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
}