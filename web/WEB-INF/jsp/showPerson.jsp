<%@ include file="/WEB-INF/jsp/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/layout.jsp" title="${actionBean.person.lastName}, ${actionBean.person.firstName}">
  

  <s:layout-component name="body">
      
      <h3>${actionBean.person.firstName} ${actionBean.person.lastName}</h3>
      <s:link beanclass="org.stripesbook.quickstart.action.EditPersonActionBean"><s:param name="person" value="${actionBean.person}"></s:param>edit</s:link>
     <p>
                              
        <c:choose>
        <c:when test="${actionBean.person.avatar != null}">
          <img src="${actionBean.person.avatar.fileName}"></img>
        </c:when>
        <c:when test="${actionBean.person.avatar == null}">
          <s:link beanclass="org.stripesbook.quickstart.action.AddImageActionBean"><s:param name="person" value="${actionBean.person}"/>Save your profile image</s:link>
        </c:when>
        </c:choose>
        <ul>
          <li>${actionBean.person.email}</li>
          <li>${actionBean.person.website}</li>
          <li>${actionBean.person.password}</li>
          <c:if test="${actionBean.person.address != null}">
          <li>Address           
            <ul>
                <li>${actionBean.person.address.name}</li>
                <li>${actionBean.person.address.streetAddress1}</li>
                <c:if test="${actionBean.person.address.streetAddress2 != null}">
                <li>${actionBean.person.address.streetAddress2}</li>
                </c:if>                
                <li>${actionBean.person.address.city}</li>
                <li>${actionBean.person.address.state}</li>
                <li>${actionBean.person.address.postalCode}</li>
                <li>${actionBean.person.address.country}</li>
            </ul>
          </li>
          </c:if>
          <c:if test="${actionBean.person.address == null}">
          <s:link beanclass="org.stripesbook.quickstart.action.AddLocationActionBean"><s:param name="personId" value="${actionBean.person.id}"/>Add an Address</s:link>
          </c:if>
          <li>Created:${actionBean.person.created}</li>
          <li>Updated:${actionBean.person.updated}</li>
        </ul> 
      </p>

  </s:layout-component>
</s:layout-render>
