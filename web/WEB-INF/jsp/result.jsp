<%@ include file="/WEB-INF/jsp/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/layout.jsp" title="Welcome">
  <s:layout-component name="body">
      Hi ${actionBean.person.firstName} ${actionBean.person.lastName}! 

  
  <ul>
  <c:forEach var="person" items="${actionBean.personsList}">        
    <li>${person.id} ${person.firstName} ${person.lastName}             
  </c:forEach>
  </ul>
  
    </s:layout-component>
  
</s:layout-render>
