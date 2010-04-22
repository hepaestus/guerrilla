<%@ include file="/WEB-INF/jsp/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/layout.jsp" title="Welcome">
  

  <s:layout-component name="body">
  <h3>Add A Person</h3>
  <s:form beanclass="org.stripesbook.quickstart.action.AddPersonActionBean">
      <s:messages/>
      <div class="field">First Name<br/><s:text name="person.firstName" /></div>
      <div class="field">Last Name<br/><s:text name="person.lastName" /></div>
      <div class="field">Email<br/><s:text name="person.email" /></div>
      <div class="field">Web Site<br/><s:text name="person.website" /></div>
      <div class="field">Password<br/><s:text name="person.password" /></div>
      <s:submit name="newPerson" value="Save!"/>
  </s:form>
  </s:layout-component>
</s:layout-render>
