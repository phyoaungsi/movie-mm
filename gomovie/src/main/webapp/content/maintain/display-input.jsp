<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


  
    
     <link href="/maps/documentation/javascript/examples/default.css" rel="stylesheet">
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
    
    
    <script type="text/javascript">
    var map;
    var geocoder;

      function initialize() {
    	  geocoder = new google.maps.Geocoder();

    	var myLatlng=new google.maps.LatLng(16.7799, 96.1565);
        var mapOptions = {
          center: myLatlng,
          zoom: 12,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
         map = new google.maps.Map(document.getElementById("map-canvas"),
            mapOptions);
        
        var marker = new google.maps.Marker({
            position: myLatlng,
            map: map,
            title:"Hello World!"
            
            
        });
        
        google.maps.event.addListener(map, 'click', function(event) {
        	//alert(event.latLng);
        	
        	$('#create_latitude').val(event.latLng.lat());
        	$('#create_longitude').val(event.latLng.lng());
        	$('#create_zoomlevel').val(map.getZoom());
            placeMarker(event.latLng);
          });

        
      }
      
      function placeMarker(location) {
    	  var marker = new google.maps.Marker({
    	      position: location,
    	      map: map
    	  });

      map.setCenter(location);
      }
      
      function codeAddress() {
    	  var address = document.getElementById('address').value;
    	  geocoder.geocode( { 'address': address}, function(results, status) {
    	    if (status == google.maps.GeocoderStatus.OK) {
    	    	
    	    	$('#create_latitude').val(results[0].geometry.location.lat());
            	$('#create_longitude').val(results[0].geometry.location.lng());
            	$('#create_zoomlevel').val(map.getZoom());
            	
            	
    	      map.setCenter(results[0].geometry.location);
    	      var marker = new google.maps.Marker({
    	          map: map,
    	          position: results[0].geometry.location
    	      });
    	    } else {
    	      alert('Geocode was not successful for the following reason: ' + status);
    	    }
    	  });
    	}

      google.maps.event.addDomListener(window, 'load', initialize);
      
     
    </script>
    
    
</head>
<body>
Search Result <s:actionmessage value="keyword" />
 <input id="address" type="textbox" value="Sydney, NSW">
      <input type="button" value="Geocode" onclick="codeAddress()">

<br>
<s:iterator value="movies" status="rowstatus">
  <tr>
    <s:if test="#rowstatus.odd == true">
      <td style="background: grey"><s:property value="title"/></td><td><s:property value="date"/></td>
    </s:if>
    <s:else>
      <td><s:property value="title"/></td><td><s:property value="date"/></td>
    </s:else>
  </tr>
</s:iterator>

<s:form action="create" method="POST" enctype="multipart/form-data">

 <s:textfield label="Video Name" name="name"/>
   <s:textfield label="Embed" name="embed"/>
   <s:textfield label="Description" name="desc"/>
   <s:textfield label="Location" name="latitude"/>
   <s:textfield label="Location" name="longitude"/>
   <s:textfield label="Location" name="zoomlevel"/>
   <s:file name="upload" label="File"/>
<s:submit/>
</s:form>

 
    <div id="map-canvas" style="width:500px;height:500px"></div>
</body>
</html>