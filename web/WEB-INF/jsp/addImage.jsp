<%@ include file="/WEB-INF/jsp/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/layout.jsp" title="Add An Image">
  
  <s:layout-component name="body">
  <h3>Add An Image</h3>
  <s:form beanclass="org.stripesbook.quickstart.action.AddImageActionBean">
      <s:messages/>
      <div class="field">Title<br/><s:text name="image.title" /></div>
      <div class="field">Description<br/><s:textarea name="image.description" /></div>
      <div class="field">File Name<br/><s:text name="image.fileName" /></div>
      <div class="field">Owner Id<br/><s:text name="image.ownerId" /></div>      
      <s:submit name="newImage" value="Save!"/>
  </s:form>
  
  </s:layout-component>
</s:layout-render>
