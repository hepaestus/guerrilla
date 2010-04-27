<%@ include file="/WEB-INF/jsp/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/layout.jsp" title="Add a Person">
  

  <s:layout-component name="body">
  <h3>Register to create and account</h3>
  <s:messages/>
  <s:errors globalErrorsOnly="true"/>
  <s:form beanclass="org.stripesbook.quickstart.action.AddUActionBean">
          
      <div class="field">User Name<br/><s:text name="user.username" /></div>
      <div class="field">Email<br/><s:text name="email" /></div>   
      <div class="field">Email Confirm<br/><s:text name="confirmEmail" /></div>    
      <div class="field">Password<br/><s:text name="user.password" /></div>
      <div class="field">Confirm Password<br/><s:text name="confirmPassword" /></div>
      
      <s:submit name="newUser" value="Register"/>

  </s:form>
  </s:layout-component>
</s:layout-render>
