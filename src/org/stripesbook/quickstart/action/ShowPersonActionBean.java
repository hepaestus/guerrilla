package org.stripesbook.quickstart.action;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.stripesbook.quickstart.model.Person;
import org.stripesstuff.stripersist.Stripersist;

@UrlBinding("/ShowPerson.action")
public class ShowPersonActionBean extends BaseActionBean {
		
	private Session sess = org.stripesbook.quickstart.util.DAO.getSession();
    private Criteria crit = sess.createCriteria(Person.class);

    private Integer personId;
	private Person person;
	
    @DefaultHandler
    public Resolution view() {
     	
    	EntityManager em = Stripersist.getEntityManager();
    	
    	try {        	       	
            logger.debug("passed id:" + personId);
            
    		person = em.find(Person.class, personId);
            
        	if (logger.isDebugEnabled()) {
        		logger.debug("person.id        : " + person.getId());
        		logger.debug("person.firstname : " + person.getFirstName());
        		logger.debug("person.lastname  : " + person.getLastName());
        		logger.debug("person.email     : " + person.getEmail());
        		logger.debug("person.website   : " + person.getWebsite());
        		logger.debug("person.password  : " + person.getPassword());
        		logger.debug("person.avatar.id : " + person.getAvatar());
        		logger.debug("person.address.id: " + person.getAddress());
        	}
 
    	} catch (Exception e) {
    		e.printStackTrace();
    	}   	
        return new ForwardResolution("/WEB-INF/jsp/showPerson.jsp");
    }

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}