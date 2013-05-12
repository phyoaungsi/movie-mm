<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<s:url id="news" action="news" namespace="/news" />
<script>

$(function() {
	$( "#menu" ).menu();
});
</script>

<ul id="menu">
<li class="ui-state-disabled"><a href="#">Aberdeen</a></li>
<li><a href="#"><img src="<s:url value="/images/plane_ico.png"/>"/>&nbsp; Airlines</a></li>
<li> <s:a href="%{news}"><img src="<s:url value="/images/globe_ico.png"/>"/>&nbsp;News</s:a></li>
<li><a href="#"><img src="<s:url value="/images/beach_logo1.png"/>"/>&nbsp;Beaches</a></li>
<li>
<a href="#"><img src="<s:url value="/images/beach_logo.png"/>"/>&nbsp;Islands</a>
<ul>
<li class="ui-state-disabled"><a href="#">Ada</a></li>
<li><a href="#">Saarland</a></li>
<li><a href="#">Salzburg</a></li>
</ul>
</li>
<li><a href="#">Saarland</a></li>
<li>
<a href="#">Salzburg</a>
<ul>
<li>
<a href="#">Delphi</a>
<ul>
<li><a href="#">Ada</a></li>
<li><a href="#">Saarland</a></li>
<li><a href="#">Salzburg</a></li>
</ul>
</li>
<li>
<a href="#">Delphi</a>
<ul>
<li><a href="#">Ada</a></li>
<li><a href="#">Saarland</a></li>
<li><a href="#">Salzburg</a></li>
</ul>
</li>
<li><a href="#">Perch</a></li>
</ul>
</li>
<li class="ui-state-disabled"><a href="#">Amesville</a></li>
</ul>
