<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

response.setHeader("Access-Control-Allow-Origin","*");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Amazing Land,Amazing People</title>
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
    <script>

var map;
var markers = [];
var iterator=0;
var running_man;
function initialize() {
var myLatLng = new google.maps.LatLng(16.830162631091017, 96.17090463638306);

  var mapOptions = {
    zoom: 16,
    center: myLatLng ,
    mapTypeId: google.maps.MapTypeId.ROADMAP
  };
  map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);



var ctaLayer = new google.maps.KmlLayer({
    url: 'http://quest.whereismyanmar.net/travelmyanmar1.kml'
  });
  ctaLayer.setMap(map);



 var infowindow = new google.maps.InfoWindow({
    content: 'Change the zoom level',
    position: myLatLng
  });

 // infowindow.open(map);

  google.maps.event.addListener(map, 'zoom_changed', function() {
    var zoomLevel = map.getZoom();
   // map.setCenter(myLatLng);
  var bounds = map.getBounds();
var southWest = bounds.getSouthWest();
var northEast = bounds.getNorthEast();
   // infowindow.setContent('Zoom: ' + zoomLevel+'north'+northEast.lat());
  });


google.maps.event.addListener(map, 'idle', function() {
    // 3 seconds after the center of the map has changed, pan back to the
    // marker.


     var bounds = map.getBounds();
var southWest = bounds.getSouthWest();

var northEast = bounds.getNorthEast();

    infowindow.setContent('north'+northEast.lat());
    <s:url id="ajax.movies.first" namespace="/ajax" action="GetLatLngDistributedListAction" />
req_init("<s:property value="ajax.movies.first"/>",{ lat1: northEast.lat() , lat0: southWest.lat(),lng0: southWest.lng(), lng1: northEast.lng()});

<s:url id="ajax.movies" namespace="/ajax" action="GetLatLngListAction" />

$.ajax({
type: "POST",
url: "<s:property value="ajax.movies.first"/>",
data: { lat1: northEast.lat() , lat0: southWest.lat(),lng0: southWest.lng(), lng1: northEast.lng()}
}).done(function(datar) {processData(datar);});
 
 });



}

google.maps.event.addDomListener(window, 'load', initialize);


function toggleBounce(pinmarker) {

  if (pinmarker.getAnimation() != null) {
    pinmarker.setAnimation(null);
  } else {
    pinmarker.setAnimation(google.maps.Animation.BOUNCE);
  }
running_man=pinmarker;
}

function deBounce() {

  if (running_man.getAnimation() != null) {
    running_man.setAnimation(null);
  }
}

function drop(latlng) {
 
    setTimeout(function() {
      addMarker(latlng);
    }, 1 * 200);
  
}

function addMarker(latlng) {


  var marker=new google.maps.Marker({
    position: latlng,
    map: map,
    draggable: false,
    animation: google.maps.Animation.DROP
  });
  markers.push(marker);

 google.maps.event.addListener(marker, 'click', function() {
    map.setZoom(16);
    map.setCenter(marker.getPosition());
  });

 // iterator++;
}


function processData(datar){

			$('#map-video-list').html('');
			//var data=JSON.parse(datar);
			var data=datar;
			if(data.movies.length>0)
			{
			for(var i=0;i<data.movies.length;i++)
			{
			
			   var movie=data.movies[i];
			   var icon='<li class="clip-result-right  ui-state-default" > '+    
			'<div id="thumbnail" style="float:left" > <img onmouseover="toggleBounce(markers['+iterator+']);" onmouseout="deBounce();" width="140px" height="84px" src="/gomovie/download.do?fileName='+movie.thumbnail+'"></div>'+ 
			     ' <div style="width:150px;text-transform: capitalize;text-align:left;float:right" class="">  '+            
			     ' <a href="/gomovie/display/showmovie.do?id='+movie.uuid+'">&nbsp;'+movie.title+'</a>'+ 
			      '</div>   '+   
			      ' <div id="description">'+ 
			       '<a href="/gomovie/viewmap.htm?|'+movie.map.lattitude+'|'+movie.map.longitude+'|'+movie.map.zoomLevel+'"><img width="30px" height="30px" src="/gomovie/images/04_maps.png"></a>'+ 
			       '</div> '+ 
			 ' </li>';
			
			$('#map-video-list').append(icon);
			var pinLocation= new google.maps.LatLng(movie.map.lattitude, movie.map.longitude);
			drop(pinLocation);
			iterator++;
			}}
			$('#map-video-list > li').hover(
			     function () {
			         // alert('hover');
			        $(this).addClass('ui-state-hover');
			     },
			     function () {
			         $(this).removeClass('ui-state-hover');
			    }
			);
			//var i=document.getElementById('super_container');
			//alert(i);
			//if(i==null){
				//$('#container').wrap('<div id="super_container" style="width:100%;height:100%;background:red;display:none;" />');
				//$("#super_container").css('background-image',"url('http://famouswonders.com/wp-content/uploads/2009/04/kandawgyi-lake-yangon-and-shwedagon-pagoda-in-the-background.jpg')");
			//}
			//$("#super_container").fadeOut('slow');
}


    </script>


<script type="text/javascript">
    var xdr;

    function read_data()
    {
        var output = document.getElementById('text_response');
        if(output)
        {
        // To view the responseText on the page, click the Read button. 
            output.innerText = xdr.responseText;
        }

        // The Read button also displays the content type and length of 
        // response in alerts.  
        //alert("Content-type: " + xdr.contentType);
       // alert("Length: " + xdr.responseText.length);
     

    }

    function alert_error()
    {
        alert("XDR onerror");
    }

    function alert_timeout()
    {
       // alert("XDR ontimeout");
    }

    function alert_loaded()
    {
        //alert("XDR onload");
       // alert("Got: " + xdr.responseText);
       processData(xdr.responseText);
    }

    function alert_progress()
    {
        //alert("XDR onprogress");
       // alert("Got: " + xdr.responseText);
    }

    function req_abort()
    {
        if(xdr)
        {
            xdr.abort(); // Abort XDR if the Stop button is pressed. 
        }
    }

    function req_init(uri,postdata)
    {
        var url = uri;
        var timeout = 17000;
        if (window.XDomainRequest) // Check whether the browser supports XDR. 
        {
            xdr = new XDomainRequest(); // Create a new XDR object.
            if (xdr)
            {
                // There is an error and the request cannot be completed. 
                // For example, the network is not available.
                xdr.onerror     = alert_error;
                        
                // This event is raised when the request reaches its timeout. 
                xdr.ontimeout   = alert_timeout;
                        
                // When the object starts returning data, the onprogress event 
                // is raised and the data can be retrieved by using responseText.
                xdr.onprogress  = alert_progress;
                       
                // When the object is complete, the onload event is raised and 
                // the responseText ensures the data is available. 
                xdr.onload      = alert_loaded;

                xdr.timeout     = timeout;
                        
                // The URL is preset in the text area. This is passed in the 
                // open call with a get request.
                xdr.open("POST", url);
                       
                // The request is then sent to the server. 
                // alert($.param(postdata));
                xdr.send($.param(postdata));
            }
            else
            {
               // alert('Failed to create new XDR object.');
            }
        }
        else
        {
           
        }
    }

</script>
 </head>
<body>
<s:if test="#keyword !=null">
Search Result <s:property value="keyword" />
</s:if>
<table width="100%"><tr><td>
<div id=map-canvas style="height:400px;width:100%">Loading Map...</div>

<div class="clip-container imgbg">
<ul>
<s:iterator value="movies1" status="rowstatus">
   <s:url id="testUrlId" namespace="/display" action="showmovie">
                  <s:param name="id" value="%{uuid}"></s:param>           
      </s:url>
  <s:url id="image.url" action="download" namespace="/">
      <s:param name="fileName" value="%{thumbnail}"/>
      </s:url>

  <li class="clip-result">

      
<div id="thumbnail"> <img width=140px height=84px src="http://www-01.ibm.whereismyanmar.net/images/<s:property value="thumbnail" />" /></div>
      <div class="" style="width:150px;text-transform: capitalize; text-shadow: -2px 2px 3px;">             
      <s:a href="%{testUrlId}">
      &nbsp;<s:property value="title"/>
     
      </s:a>
      </div>
      
       <div id="description"><%-- <div class="desc-item"><s:property value="description"/></div> --%>
       <a href="<%=request.getContextPath() %>/viewmap.htm?|<s:property value="map.lattitude"/>|<s:property value="map.longitude"/>|<s:property value="map.zoomLevel"/>"><img src="<%=request.getContextPath() %>/images/04_maps.png" width="30px" height="30px"/></a>
       </div>
  
  </li>
</s:iterator>

</ul>

</div>
</td></tr></table>
<script>

$(document).ready(function(){



$('.desc-item').each(function(index){

var text=$(this).text();
if(text.length>250){
text=text.substring(0,250);

$(this).text(text+'...');
}
});




});


</script>

</body>
</html>