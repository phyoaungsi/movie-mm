<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>News</title>


<script>
	$(function() {
		$( "input[type=submit],button" )
			.button()
			.click(function( event ) {
				//event.preventDefault();
			});
		
		$("#topsearch").button({
			icons: {
				primary: "ui-icon-search"
			}	
		});
		
		
		

		
		
	});
	

	
	

	
	</script>
<style>

.news-header{

font-family:Georgia
font-size:15px;
font-weight:700;
color:#093D72;
line-height:16.5px;
text-align:left;

}


</style>
</head>
<body>
Today Update <s:property value="keyword" />

<br>
<table>
<s:iterator value="feeds" status="rowstatus">
 
 <s:if test="#rowstatus.odd == true">
  <tr class="news-update">
   </s:if>
      <td class="news-item" style="">
      <div class="news-header" style="width:100%;margin-left:7px;border-top: 1px solid #cfcfcf;">             
     
      &nbsp;<s:property value="title"/>
     
            </div>
      <div id="thumbnail"> </div>
       <div id="description" style="width:300px"><s:property value="description" escape="false"/>
      
       </div>
       </td>
    <s:if test="#rowstatus.odd == false">
  </tr>
</s:if>
</s:iterator>
</table>
</body>
</html>