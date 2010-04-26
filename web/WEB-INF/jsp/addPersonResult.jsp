<%@ include file="/WEB-INF/jsp/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/layout.jsp" title="Add a Person">
  <s:layout-component name="body">
      <p>
        Hi ${actionBean.person.firstName} ${actionBean.person.lastName}!
        <ul>
          <li>${actionBean.person.email}</li>
          <li>${actionBean.person.website}</li>
          <li>${actionBean.person.password}</li>
        </ul> 
      </p>
   
      <h2>Person List</h2>
      <p>
	    <ul>
	    <c:forEach var="person" items="${actionBean.personsList}">        
	    <li>User ID: <s:link beanclass="org.stripesbook.quickstart.action.ShowPersonActionBean" ><s:param name="personId" value="${person.id}"/>${person.id}</s:link>
	        <ul>
	          <li>${person.firstName} ${person.lastName}</li>
	          <li>${person.email}</li>
	          <li>${person.website}</li>
	          <li>${person.password}</li>
	        </ul>
	      </li>
	    </c:forEach>
	    </ul>
      </p>
  </s:layout-component>
  
</s:layout-render>
