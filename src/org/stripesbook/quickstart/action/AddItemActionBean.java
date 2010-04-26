package org.stripesbook.quickstart.action;

import java.util.Date;
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
import org.stripesbook.quickstart.model.TrackableItem;
import org.stripesstuff.stripersist.Stripersist;

@UrlBinding("/AddItem.action")
public class AddItemActionBean extends BaseActionBean {
		
	private static final String RESULT = "/WEB-INF/jsp/addItemResult.jsp";
	private Session sess = org.stripesbook.quickstart.util.DAO.getSession();
    private Criteria crit = sess.createCriteria(TrackableItem.class);
    
	private TrackableItem item;
	private List<TrackableItem> itemsList;
	
    @DefaultHandler
    public Resolution view() {
        return new ForwardResolution("/WEB-INF/jsp/addItem.jsp");
    }
        
    public Resolution newItem() {
    	
    	EntityManager em = Stripersist.getEntityManager();
    	
    	item.setCreated(new Date());
    	
    	try {        	
        	if (logger.isDebugEnabled()) {
        		logger.debug("item.id          : " + item.getId());
        		logger.debug("item.name        : " + item.getName());
        		logger.debug("item.description : " + item.getDescription());        		
        		logger.debug("item.url         : " + item.getUrl());
        		logger.debug("item.created     : " + item.getCreated());
        		logger.debug("item.lookupUrl   : " + item.getLookupUrl());        		
        	}        	

        	em.persist(item);
    		em.getTransaction().commit();
    		logger.debug("committed");

    	} catch (EntityExistsException eee) {
    		em.getTransaction().rollback();
    		eee.printStackTrace();
    	}
    	
    	populateItemList();
    	return new ForwardResolution(RESULT);
    }
    
    public void populateItemList() {
        
        logger.debug("populate item list");
        sess.createCriteria(TrackableItem.class);
        crit.addOrder(Order.asc("name"));
        itemsList = crit.list();        
        
    }

    public TrackableItem getItem() {
        return item;
    }

    public void setItem(TrackableItem item) {
        this.item = item;
    }

    public List<TrackableItem> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<TrackableItem> itemsList) {
        this.itemsList = itemsList;
    }    
}