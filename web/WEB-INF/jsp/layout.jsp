<%@ include file="/WEB-INF/jsp/taglibs.jsp" %>

<s:layout-definition>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
  <head>
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css">
    <s:layout-component name="head"/>
  </head>
  <!--body style="background-color:#247299;"-->
  <body>
  
    <div id="header">  
      <s:layout-component name="header"/>
    </div>
    
    <div id="main">
      <s:layout-component name="body"/>
    </div>
   
    <div id="footer">  
      <s:layout-component name="footer"/>
    </div>

  </body>
</html>

</s:layout-definition>