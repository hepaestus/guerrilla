<%@ include file="/WEB-INF/jsp/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/layout.jsp" title="Welcome">

  <s:layout-component name="header">  
  This is the header

  </s:layout-component>

  <s:layout-component name="body">  
  <h2>Person List</h2>
  <p><s:link beanclass="org.stripesbook.quickstart.action.AddPersonActionBean">Add A Person</s:link>
  <ul>
  <c:forEach var="person" items="${actionBean.personsList}">        
    <li>User ID: ${person.id}
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
  <p><s:link beanclass="org.stripesbook.quickstart.action.AddPersonActionBean">Add A Item</s:link>
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

  </s:layout-component>

  <s:layout-component name="footer">  
  This is the footer

  </s:layout-component>

</s:layout-render>
