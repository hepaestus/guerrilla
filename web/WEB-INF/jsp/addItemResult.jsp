<%@ include file="/WEB-INF/jsp/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/layout.jsp" title="Welcome">
  <s:layout-component name="body">
      <p>        
        <ul>
          <li>${actionBean.item.name}</li>
          <li>${actionBean.item.description}</li>
          <li>${actionBean.item.url}</li>
        </ul> 
      </p>
   
      <h2>Item List</h2>
      <p><s:link beanclass="org.stripesbook.quickstart.action.AddItemActionBean">Add An Item</s:link>
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
  
</s:layout-render>
