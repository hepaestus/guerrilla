package org.stripesbook.quickstart.action;

import javax.persistence.EntityManager;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.stripesbook.quickstart.model.TrackableItem;
import org.stripesstuff.stripersist.Stripersist;

@UrlBinding("/ShowItem.action")
public class ShowItemActionBean extends BaseActionBean {
		
	private Session sess = org.stripesbook.quickstart.util.DAO.getSession();
    private Criteria crit = sess.createCriteria(TrackableItem.class);

    private Integer itemId;
	private TrackableItem item;
	
    @DefaultHandler
    public Resolution view() {
     	
    	EntityManager em = Stripersist.getEntityManager();
    	
    	try {        	       	
            logger.debug("passed id:" + itemId);
            
    		item = em.find(TrackableItem.class, itemId);
            
        	if (logger.isDebugEnabled()) {
        		logger.debug("item.id         : " + item.getId());
        		logger.debug("item.name       : " + item.getName());
        		logger.debug("item.description: " + item.getDescription());
        		logger.debug("item.url        : " + item.getUrl());
        		logger.debug("item.lookupUrl  : " + item.getLookupUrl());
        		logger.debug("item.owner      : " + item.getOwner());
        		logger.debug("item.creator    : " + item.getCreator());
        		logger.debug("item.location   : " + item.getLocation());
        		logger.debug("item.images     i " + item.getImages());
        		logger.debug("item.created    : " + item.getCreated());
        		logger.debug("item.updated    : " + item.getUpdated());
        	}
 
    	} catch (Exception e) {
    		e.printStackTrace();
    	}   	
        return new ForwardResolution("/WEB-INF/jsp/showItem.jsp");
    }

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public TrackableItem getItem() {
		return item;
	}

	public void setItem(TrackableItem item) {
		this.item = item;
	}
}