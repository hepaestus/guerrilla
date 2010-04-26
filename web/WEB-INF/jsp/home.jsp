<%@ include file="/WEB-INF/jsp/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/layout.jsp" title="Welcome">

  <s:layout-component name="body">  
  <h2>Person List</h2>
  <p><s:link beanclass="org.stripesbook.quickstart.action.AddPersonActionBean">Add A Person</s:link>
  <ul>
  <c:forEach var="person" items="${actionBean.personsList}">        
  
    <li>User ID: <s:link beanclass="org.stripesbook.quickstart.action.ShowPersonActionBean" event="view" ><s:param name="personId" value="${person.id}"/>${person.id}</s:link>
      <ul>
        <li>${person.firstName} ${person.lastName}</li>
        <li>Email: ${person.email}</li>
        <li>Web Site: ${person.website}</li>
        <li>Password: ${person.password}</li>
      </ul>
    </li>
  </c:forEach>
  </ul>
  </p>

  <h2>Item List</h2>
  <p><s:link beanclass="org.stripesbook.quickstart.action.AddItemActionBean">Add A Item</s:link>
  <ul>
  <c:forEach var="item" items="${actionBean.itemsList}">        
    <li>Item ID: ${item.id}
      <ul>
        <li>Name: ${item.name}</li>
        <li>Description: ${item.description}</li>
        <li>Url: ${item.url}</li>
      </ul>
    </li>
  </c:forEach>
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
        <li>Postal Code: ${location.postalCode}</li>
        <li>Lat : ${location.latitude}</li>
        <li>Long: ${location.longitude}</li>
      </ul>
    </li>
  </c:forEach>
  </ul>
  </p>

  <h2>Image List</h2>
  <p><s:link beanclass="org.stripesbook.quickstart.action.AddImageActionBean">Add An Image</s:link>
  <ul>
  <c:forEach var="image" items="${actionBean.imagesList}">        
    <li>Image ID: ${image.id}
      <ul>
        <li>Title: ${image.title}</li>
        <li>Description: ${image.description}</li>
        <li>File Name: ${image.fileName}</li>
        <li>Owner Id: ${image.owner}</li>
      </ul>
    </li>
  </c:forEach>
  </ul>
  </p>

  </s:layout-component>

</s:layout-render>
