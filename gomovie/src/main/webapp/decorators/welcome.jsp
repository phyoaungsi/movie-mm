<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%

response.setHeader("Access-Control-Allow-Origin","*");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><decorator:title></decorator:title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Access-Control-Allow-Origin" content="*" />
<link rel="stylesheet" type="text/css" href="<s:url value="/css/style.css"/>" />
<link rel="stylesheet" href="<s:url value="/css/custom-theme/jquery-ui-1.10.2.custom.css"/>" />



<script src="<s:url value="/js/jquery-1.9.1.min.js"/>"></script>
	<script src="<s:url value="/js/jquery.ui.core.js"/>"></script>
	<script src="<s:url value="/js/jquery.ui.widget.js"/>"></script>
	<script src="<s:url value="/js/jquery.ui.button.js"/>"></script>
	<script src="<s:url value="/js/jquery.slides.min.js"/>"></script>
	<script src="<s:url value="/js/jquery.ui.menu.min.js"/>"></script>
       <script src="<s:url value="/js/json2.js"/>"></script>

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
		
		
		
		
		
// grab the initial top offset of the navigation 
	var sticky_navigation_offset_top = $('#leftmenu').offset().top+40;

	//var sticky_navigation_offset_top = 200;
	// our function that decides weather the navigation bar should have "fixed" css position or not.
	var sticky_navigation = function(){
		var scroll_top = $(document).scrollTop(); // our current vertical position from the top
                   if(scroll_top==0)
                    {scroll_top=document.body.scrollTop;}

		//alert(scroll_top);
		// if we've scrolled more than the navigation, change its position to fixed to stick to top, otherwise change it back to relative
		if (scroll_top > sticky_navigation_offset_top) { 

			$('#leftmenu').css({ 'position': 'fixed', 'top':0 });
		} else {

			$('#leftmenu').css({ 'position': 'absolute','top':100 }); 
		}   
	};
	
	// run our function on load
	sticky_navigation();
	
	// and run it again every time you scroll
	$(window).scroll(function() {

		 sticky_navigation();
	});
	
	
		
		
		
	});
	

	
	

	
	</script>
	  <style>
 
    #slides {
      display: none
    }

    #slides .slidesjs-navigation {
      margin-top:3px;
    }

    #slides .slidesjs-previous {
      margin-right: 5px;
      float: left;
    }

    #slides .slidesjs-next {
      margin-right: 5px;
      float: left;
    }

    .slidesjs-pagination {
      margin: 6px 0 0;
      float: right;
      list-style: none;
    }

    .slidesjs-pagination li {
      float: left;
      margin: 0 1px;
    }

    .slidesjs-pagination li a {
      display: block;
      width: 13px;
      height: 0;
      padding-top: 13px;
      background-image: url(../css/slidejs/img/pagination.png);
      background-position: 0 0;
      float: left;
      overflow: hidden;
    }

    .slidesjs-pagination li a.active,
    .slidesjs-pagination li a:hover.active {
      background-position: 0 -13px
    }

    .slidesjs-pagination li a:hover {
      background-position: 0 -26px
    }

    #slides a:link,
    #slides a:visited {
      color: #333
    }

    #slides a:hover,
    #slides a:active {
      color: #9e2020
    }

    .navbar {
      overflow: hidden
    }
  </style>
<style>
    #slides {
      display: none
    }

    .container {
      margin: 0 auto
    }

    /* For tablets & smart phones */
    @media (max-width: 767px) {
      body {
        padding-left: 20px;
        padding-right: 20px;
      }
      .container {
        width: auto
      }
    }

    /* For smartphones */
    @media (max-width: 480px) {
      .container {
        width: auto
      }
    }

    /* For smaller displays like laptops */
    @media (min-width: 768px) and (max-width: 979px) {
      .container {
        width: 724px
      }
    }

    /* For larger displays */
    @media (min-width: 1200px) {
      .container {
        width: 1170px
      }
    }
.slider_container{

background-image:url('../images/Jewellery_Market,_Yangon,_Myanmar.jpg');
background-repeat:no;;
background-size:100% 100%


}

  </style>
  <decorator:head></decorator:head>
</head>
<body>
<div class="yt-grid-box yt-masthead-hh" id="yt-masthead-container"><input type="text" title="Search" onkeyup="" tabindex="1" value="" name="" class="search-term" id="masthead-search-term" style="outline: medium none;height:30px;width:600px;"></input>&nbsp;<button id="topsearch">Search</button></div>
<br/>

<div id="leftmenu" style="width:120px;position:absolute;left:5px;">

<s:include value="left_menu.jsp"/>
</div>
<div style="width:100%;text-align:center;padding:5px" class="slider_container">
  <div class="container" style="width:700px;height:300px;background:white;padding:5px">
    <div id="slides">
     <div> <table> <tr>
     
     <td><img src="../images/demo/1b.jpg" alt="Photo by: Missy S Link: http://www.flickr.com/photos/listenmissy/5087404401/"/>
     </td>
     
     <td>

     <img height=90 width=150  src="../images/demo/p1.jpg" ></img><br/>
   
     <img  height=90 width=150 src="../images/demo/p3.jpg" ></img><br/>
     <img height=90 width=150 src="../images/demo/p4.jpg" ></img><br/>
      </td>
     </tr></table>
     
     </div>
      <img width=700px height=300px src="../images/demo/1a.jpg" alt="Photo by: Missy S Link: http://www.flickr.com/photos/listenmissy/5087404401/"/>
      <img  width=700px height=300px src="../images/demo/2.jpg" alt="Photo by: Daniel Parks Link: http://www.flickr.com/photos/parksdh/5227623068/"/>
      <img  width=700px height=300px src="../images/demo/3.jpg" alt="Photo by: Mike Ranweiler Link: http://www.flickr.com/photos/27874907@N04/4833059991/"/>
      <img  width=700px height=300px src="../images/demo/4.jpg" alt="Photo by: Stuart SeegerLink: http://www.flickr.com/photos/stuseeger/97577796/"/>
     <a href="#" class="slidesjs-previous slidesjs-navigation"><i class="icon-chevron-left icon-large"></i></a>
      <a href="#" class="slidesjs-next slidesjs-navigation"><i class="icon-chevron-right icon-large"></i></a>
    </div>
    <div id="slidesjs-log" >Slide <span class="slidesjs-slide-number">1</span> of 4</div>
  </div>
</div>
  <script>
    $(function() {
      $('#slides').slidesjs({
        width: 940,
        height: 348,
        callback: {
          loaded: function(number) {
            // Use your browser console to view log
           // console.log('SlidesJS: Loaded with slide #' + number);

            // Show start slide in log
            $('#slidesjs-log .slidesjs-slide-number').text(number);
          },
          start: function(number) {
            // Use your browser console to view log
           // console.log('SlidesJS: Start Animation on slide #' + number);
          },
          complete: function(number) {
            // Use your browser console to view log
           // console.log('SlidesJS: Animation Complete. Current slide is #' + number);

            // Change slide number on animation complete
            $('#slidesjs-log .slidesjs-slide-number').text(number);
          }
        }
      });
    });
  </script>

  
  


<div id="container" >
<div id="header">


</div>

<div id="conent">
<div class="right_col">
<div id=map-video class='clip-container-right thumbnail-panel'><ul id="map-video-list"></ul></div>
<!--
<div style="margin-top:0px;background:red;position:relative" class="db2">
<div class="bd2_top" tyle="margin-top:0px;background:green" >
<div class="bd2_top_content">&nbsp;</div>
</div>

<div class="db2_content">
<h3 class="ui-state-default ui-corner-top" style=""> Latest Movies</h3>
<div class="db2_content_container">

<br>
<br>
Latest movie<br>
list </div>
</div>
<div class="bd2_bot">
<div class="bd2_bot_content">&nbsp;</div>
</div>
</div> -->

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