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
import org.stripesbook.quickstart.model.Image;
import org.stripesstuff.stripersist.Stripersist;

@UrlBinding("/AddImage.action")
public class AddImageActionBean extends BaseActionBean {
		
	private static final String RESULT = "/WEB-INF/jsp/addImageResult.jsp";
	private Session sess = org.stripesbook.quickstart.util.DAO.getSession();
    private Criteria crit = sess.createCriteria(Image.class);
    
	private Image image;
	private List<Image> imagesList;
	
    @DefaultHandler
    public Resolution view() {
        return new ForwardResolution("/WEB-INF/jsp/addImage.jsp");
    }
        
    public Resolution newImage() {
    	
    	EntityManager em = Stripersist.getEntityManager();
    	
    	try {        	
        	if (logger.isDebugEnabled()) {
        		logger.debug("image.id          : " + image.getId());
        		logger.debug("image.title       : " + image.getTitle());
        		logger.debug("image.description : " + image.getDescription());        		
        		logger.debug("image.fileName    : " + image.getFileName());
        		logger.debug("image.owner       : " + image.getOwner());
        	}        	

        	em.persist(image);
    		em.getTransaction().commit();
    		logger.debug("committed");

    	} catch (EntityExistsException eee) {
    		em.getTransaction().rollback();
    		eee.printStackTrace();
    	}
    	
    	populateImageList();
    	return new ForwardResolution(RESULT);
    }
    
    public void populateImageList() {
        
        logger.debug("populate image list");
        sess.createCriteria(Image.class);
        crit.addOrder(Order.asc("title"));
        imagesList = crit.list();        
        
    }

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public List<Image> getImagesList() {
		return imagesList;
	}

	public void setImagesList(List<Image> imagesList) {
		this.imagesList = imagesList;
	}   
}