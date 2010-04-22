<%@ include file="/WEB-INF/jsp/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/layout.jsp" title="Welcome">
  

  <s:layout-component name="body">
  <h3>Add An Item</h3>
  <s:form beanclass="org.stripesbook.quickstart.action.AddItemActionBean">
      <s:messages/>
      <div class="field">Name<br/><s:text name="item.name" /></div>
      <div class="field">Description<br/><s:textarea name="item.description" /></div>
      <div class="field">Url<br/><s:text name="item.url" /></div>      
      <s:submit name="newItem" value="Save!"/>
  </s:form>
  
  </s:layout-component>
</s:layout-render>
