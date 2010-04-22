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
import org.stripesbook.quickstart.model.Person;
import org.stripesbook.quickstart.model.TrackableItem;
import org.stripesstuff.stripersist.Stripersist;

@UrlBinding("/Home.action")
public class HomeActionBean extends BaseActionBean {
		
	private static final String RESULT = "/WEB-INF/jsp/result.jsp";

	private Session sess = org.stripesbook.quickstart.util.DAO.getSession();
    private Criteria critPerson = sess.createCriteria(Person.class);
    private Criteria critItem = sess.createCriteria(TrackableItem.class);
    
	private List<Person> personsList;
	private List<TrackableItem> itemsList;

    @DefaultHandler
    public Resolution view() {
    	populatePersonsList();
    	populateItemsList();
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
        setItemsList(critItem.list());        
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
}