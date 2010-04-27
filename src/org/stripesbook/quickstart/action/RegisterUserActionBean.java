/*
 * Copyright 2008 ISO New England, Inc.  All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * ISO New England, Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms specified by ISO New England.  
 * 
 */

package org.stripesbook.quickstart.action;

import javax.persistence.EntityManager;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.DontValidate;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.ValidationErrorHandler;
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMethod;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.stripesbook.quickstart.model.User;
import org.stripesstuff.stripersist.Stripersist;

public class RegisterUserActionBean extends BaseActionBean implements ValidationErrorHandler {

    private static final String view = "/WEB-INF/jsp/registerResult.jsp";
    
    private Session sess = org.stripesbook.quickstart.util.DAO.getSession();
    private Criteria crit = sess.createCriteria(User.class);
    
    private User user;    
    private String confirmPassword;
    private String email;
    private String confirmEmail;
            
    @DefaultHandler
    @DontValidate    
    public Resolution view() {
        return new ForwardResolution(view);
    }
    
    @ValidateNestedProperties(
        {
            @Validate(field="username", required=true),
            @Validate(field="email", required=true),
            @Validate(field="password", required=true),                        
        }
    )
    
    public void setUser(User user) {
        this.user = user;        
    }
    
    public String getConfirmPassword() {
        return confirmPassword;
    }
    
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    @ValidationMethod
    public void validateUsernameAndPasswords(ValidationErrors errors) {
        String username = user.getUsername();
        EntityManager em = Stripersist.getEntityManager();
        
        User foundUser = em.find(User.class, username);              
         if ( foundUser != null ) {
             errors.addGlobalError( new SimpleError(username + " is already taken"));
         }
         if(!user.getPassword().equals(confirmPassword)) {
             errors.addGlobalError( new SimpleError("passwords do not match"));
         }        
    }   
    @ValidationMethod
    public void validateEmail(ValidationErrors errors) {
        
        EntityManager em = Stripersist.getEntityManager();
        
        User foundUser = em.find(User.class, email);              
         if ( foundUser != null ) {
             errors.addGlobalError( new SimpleError(email + " is already in user are you already a user?"));
         }
         if(!email.equals(confirmEmail)) {
             errors.addGlobalError( new SimpleError("email addresses do not match"));
         }        
    }
    
    public Resolution handleValidationErrors (ValidationErrors errors) {
        if (errors.hasFieldErrors() ) {
            errors.addGlobalError( new SimpleError("All fields are required."));
        }
        return null;        
    }
}
