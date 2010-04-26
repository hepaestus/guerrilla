<%@ include file="/WEB-INF/jsp/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/layout.jsp" title="Add a Location">
  

  <s:layout-component name="body">
  <h3>Add An Location</h3>
  <s:form beanclass="org.stripesbook.quickstart.action.AddLocationActionBean">
      <s:messages/>
      <c:choose>
        <c:when test="${personId != null}">
          <p>Adding this address to the user with id ${personId}</p>        
          <s:hidden name="personId" value="${personId}"></s:hidden>  
        </c:when>
        <c:when test="${itemId != null}">
          <s:hidden name="itemId" value="${itemId}"></s:hidden>  
        </c:when>
        <c:otherwise>
        <p>No ID Info PASSED</p>
        </c:otherwise>
      </c:choose>
      <div class="field">Name<br/><s:text name="location.name" /></div>
      <div class="field">Address<br/><s:text name="location.streetAddress1" /></div>
      <div class="field">Addr. Cont.<br/><s:text name="location.streetAddress2" /></div>
      <div class="field">City<br/><s:text name="location.city" /></div> 
      <div class="field">State<br/><s:text name="location.state" /></div>
      <div class="field">Postal Code<br/><s:text name="location.postalCode" /></div> 
      <div class="field">Country<br/><s:text name="location.country" /></div>
      <div class="field">Latitude<br/><s:text name="location.latitude" /></div> 
      <div class="field">Longitude<br/><s:text name="location.longitude" /></div>      
      <s:submit name="newLocation" value="Save!"/>
  </s:form>
  
  </s:layout-component>
</s:layout-render>
