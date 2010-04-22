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
import org.stripesstuff.stripersist.Stripersist;

@UrlBinding("/AddPerson.action")
public class AddPersonActionBean extends BaseActionBean {
		
	private static final String RESULT = "/WEB-INF/jsp/addPersonResult.jsp";
	private Session sess = org.stripesbook.quickstart.util.DAO.getSession();
    private Criteria crit = sess.createCriteria(Person.class);
    
	private Person person;
	private List<Person> personsList;
	
    @DefaultHandler
    public Resolution view() {
        return new ForwardResolution("/WEB-INF/jsp/addPerson.jsp");
    }
        
    public Resolution newPerson() {
    	
    	EntityManager em = Stripersist.getEntityManager();
    	
    	try {        	
        	if (logger.isDebugEnabled()) {
        		logger.debug("person.id        : " + person.getId());
        		logger.debug("person.firstname : " + person.getFirstName());
        		logger.debug("person.lastname  : " + person.getLastName());
        		logger.debug("person.email     : " + person.getEmail());
        		logger.debug("person.website   : " + person.getWebsite());
        		logger.debug("person.password  : " + person.getPassword());
        	}        	

        	em.persist(person);
    		em.getTransaction().commit();
    		logger.debug("committed");

    	} catch (EntityExistsException eee) {
    		em.getTransaction().rollback();
    		eee.printStackTrace();
    	}
    	
    	populateList();
    	return new ForwardResolution(RESULT);
    }
    
    public void populateList() {
        
        logger.debug("populate Person list");
        sess.createCriteria(Person.class);
        crit.addOrder(Order.asc("firstName"));
        personsList = crit.list();        
        
    }
    
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}


    public List<Person> getPersonsList() {
        return personsList;
    }


    public void setPersonsList(List<Person> personsList) {
        this.personsList = personsList;
    }
}