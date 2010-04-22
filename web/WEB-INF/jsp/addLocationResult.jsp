<%@ include file="/WEB-INF/jsp/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/layout.jsp" title="Welcome">
  <s:layout-component name="body">
      <p>        
        <ul>
            <li>Name: ${actionBean.location.name}</li>
            <li>Address: ${actionBean.location.streetAddress1}</li>
            <li>Addr. Cont.: ${actionBean.location.streetAddress2}</li>
            <li>City: ${actionBean.location.city}</li>
            <li>Stat: ${actionBean.location.state}</li>
            <li>Postal Code: ${actionBean.location.postalCode}</li>
            <li>Lat : ${actionBean.location.latitude}</li>
            <li>Long: ${actionBean.location.longitude}</li>
        </ul> 
      </p>
   
      <h2>Location List</h2>
      <p><s:link beanclass="org.stripesbook.quickstart.action.AddLocationActionBean">Add An Location</s:link>
      <ul>
      <c:forEach var="location" items="${actionBean.locationsList}">        
        <li>Location ID: ${location.id}
          <ul>
            <li>Name: ${location.name}</li>
            <li>Address: ${location.streetAddress1}</li>
            <li>Addr. Cont.: ${location.streetAddress2}</li>
            <li>City: ${location.city}</li>
            <li>Stat: ${location.state}</li>
            <li>Postal Code: ${location.postalCose}</li>
            <li>Lat : ${location.latitude}</li>
            <li>Long: ${location.longitude}</li>
          </ul>
        </li>
      </c:forEach>
      </ul>
      </p>
  </s:layout-component>
  
</s:layout-render>
