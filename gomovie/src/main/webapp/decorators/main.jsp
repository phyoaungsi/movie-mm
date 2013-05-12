<?xml version="1.0" encoding="UTF-8" ?>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><decorator:title></decorator:title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<s:url value="/css/style.css"/>" />
<link rel="stylesheet" href="<s:url value="/css/themes/le-frog/jquery.ui.all.css"/>" />

<script src="<s:url value="/js/jquery-1.8.3.js"/>"></script>
	<script src="<s:url value="/js/jquery.ui.core.js"/>"></script>
	<script src="<s:url value="/js/jquery.ui.widget.js"/>"></script>
	<script src="<s:url value="/js/jquery.ui.button.js"/>"></script>
	<script src="<s:url value="/js/jquery.slides.min.js"/>"></script>
	
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
<decorator:head></decorator:head>
</head>
<body>
<div class="yt-grid-box yt-masthead-hh" id="yt-masthead-container"><input type="text" title="Search" onkeyup="" tabindex="1" value="" name="" class="search-term" id="masthead-search-term" style="outline: medium none;height:30px;width:600px;"></input>&nbsp;<button id="topsearch">Search</button></div>

<div id="container" >
<div id="header">


</div>

<div id="conent">
<div class="right_col">
<div class="db2" style="margin-top:0px" >
<div class="bd2_top">
<div class="bd2_top_content">&nbsp;</div>
</div>
<div class="db2_content">
<div class="db2_content_container">
<h3> Latest Movies</h3>
<br />
<br />
Latest movie<br />
list </div>
</div>
<div class="bd2_bot">
<div class="bd2_bot_content">&nbsp;</div>
</div>
</div>


</div>
<div class="left_col">
<div class="db1" style="width:700px">
<div class="db1_title" >
<h3><decorator:title/></h3>
</div>
<div class="db1_content">
<div class="db1_container">


<decorator:body />




</div>
</div>
</div>
</div>
<div id="footer" >
<div id="copyright"> Copyright 2008 Your Company Name </div>
<div id="designby">Design by <a href="http://www.flashdaweb.com/">PAS</a></div>
<div id="bottom_menu"> </div>
</div>
</div>
</div>
<div align=center>Myannmar Movie Drama <a href='http://www.mmdrama.com/'>2013</a></div></body>

</html>