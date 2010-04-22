package org.stripesbook.quickstart.action;

import org.apache.log4j.Logger;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;

public class BaseActionBean implements ActionBean {

	protected static Logger logger = Logger.getLogger(HomeActionBean.class);	
	
	private ActionBeanContext context;

    public ActionBeanContext getContext() {
        return context;
    }
    public void setContext(ActionBeanContext context) {
        this.context = context;
    }
}