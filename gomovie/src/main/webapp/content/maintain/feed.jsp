<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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
      
     
      
      function GetURLParameter(sParam)
      	{
      	    var sPageURL = window.location.search.substring(1);
      	    var sURLVariables = sPageURL.split('&');
          for (var i = 0; i < sURLVariables.length; i++)
      	    {
      	        var sParameterName = sURLVariables[i].split('=');
      	        if (sParameterName[0] == sParam)
      	        {
      	            return sParameterName[1];
      	        }
      	    }
          }

      $('#url').change(function() {
    	 $('#address').val(GetURLParameter(q));
    	  });
      
    </script>
    
</head>
<body>
 
      <s:actionmessage />
      <s:actionerror/>
<s:form action="feed" method="POST" >

 <s:textfield label="RSS URL" name="url" id="url"/>
<s:textfield label="Address" name="address" id="address"/>
 <input type="button" value="Verify Address" onclick="codeAddress()">
<s:submit/>
</s:form>
      
    <div id="map-canvas" style="width:500px;height:500px"></div>
      
</body>
</html>