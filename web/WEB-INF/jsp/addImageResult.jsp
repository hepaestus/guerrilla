<%@ include file="/WEB-INF/jsp/taglibs.jsp" %>
	
<s:layout-render name="/WEB-INF/jsp/layout.jsp" title="Add an Image">
  <s:layout-component name="body">
      <p>        
        <ul>
          <li>${actionBean.image.title}</li>
          <li>${actionBean.image.description}</li>
          <li>${actionBean.image.fileName}</li>
          <li>${actionBean.image.ownerId}</li>
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
            <li>Owner Id: ${image.ownerId}</li>
          </ul>
        </li>
      </c:forEach>
      </ul>
      </p>
  </s:layout-component>
  
</s:layout-render>
