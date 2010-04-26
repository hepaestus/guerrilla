<%@ include file="/WEB-INF/jsp/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/layout.jsp" title="${actionBean.item.name}">
  
  <s:layout-component name="body">
      
      <h3>${actionBean.item.name}</h3>
      <s:link beanclass="org.stripesbook.quickstart.action.EditItemActionBean">edit</s:link>
     <p>
        <c:if test="${actionBean.item.}">
        </c:if>                              
        <ul>
          <li>${actionBean.item.email}</li>
          <li>${actionBean.item.website}</li>
          <li>${actionBean.item.password}</li>
          <c:if test="${actionBean.item.address != null}">
          <li>Address           
            <ul>
                <li>${actionBean.item.address.name}</li>
                <li>${actionBean.item.address.streetAddress1}</li>
                <c:if test="${actionBean.item.address.streetAddress2 != null}">
                <li>${actionBean.item.address.streetAddress2}</li>
                </c:if>                
                <li>${actionBean.item.address.city}</li>
                <li>${actionBean.item.address.state}</li>
                <li>${actionBean.item.address.postalCode}</li>
                <li>${actionBean.item.address.country}</li>
            </ul>
          </li>
          </c:if>
          <c:if test="${actionBean.item.address == null}">
          <s:link beanclass="org.stripesbook.quickstart.action.AddLocationActionBean"><s:param name="itemId" value="${actionBean.item.id}"/>Add an Address</s:link>
          </c:if>
          <li>Created:${actionBean.item.created}</li>
          <li>Updated:${actionBean.item.updated}</li>
        </ul> 
      </p>

  </s:layout-component>
</s:layout-render>
