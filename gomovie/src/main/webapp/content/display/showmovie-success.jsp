<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
        <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:property value="movie.title" escape="true" /></title>
</head>
<body>

<s:property value="movie.embed" escape="false" />



<table>
<s:iterator value="nearByMoives" status="rowstatus">
   <s:url id="testUrlId" namespace="/display" action="showmovie">
                  <s:param name="id" value="%{uuid}"></s:param>           
      </s:url>
  <s:url id="image.url" action="download" namespace="/">
      <s:param name="fileName" value="%{thumbnail}"/>
      </s:url>
  <tr class="movieresult">
   
      <td class="movieitem">
      <div class="" style="width:100%;text-transform: capitalize; text-shadow: -2px 2px 3px;">             
      <s:a href="%{testUrlId}">
      &nbsp;<s:property value="title"/>
     
      </s:a>
      </div>
      <div id="thumbnail"> <img width=320px height=180px src="<s:property value="image.url" />" /></div>
       <div id="description"><s:property value="description"/>
       <a href="<%=request.getContextPath() %>/viewmap.htm?|<s:property value="map.lattitude"/>|<s:property value="map.longitude"/>|<s:property value="map.zoomLevel"/>"><img src="<%=request.getContextPath() %>/images/04_maps.png" width="30px" height="30px"/></a>
       </div>
       </td>
   
  </tr>
</s:iterator>
</table>
</body>
</html>