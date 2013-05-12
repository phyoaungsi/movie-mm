package com.mmdrama.core.webservice.google;

import java.math.BigDecimal;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;

public class GeoCode  {
	
	
        private static final long serialVersionUID = 505880800243863955L;
      
        GeocodeResponse geocoderResponse =new GeocodeResponse();

        public  void searchAddress(String address)
        {
        	  final Geocoder geocoder = new Geocoder();
              GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(address).setLanguage("en").getGeocoderRequest();
               geocoderResponse = geocoder.geocode(geocoderRequest);
             BigDecimal a=  geocoderResponse.getResults().get(0).getGeometry().getLocation().getLat();
             System.out.println(a.toPlainString());
        }
         public BigDecimal getLat()
         {
        	 
        	 return  geocoderResponse.getResults().get(0).getGeometry().getLocation().getLat();
         }
         
         public BigDecimal getLng()
         {
        	 
        	 return  geocoderResponse.getResults().get(0).getGeometry().getLocation().getLng();
         }
	    
	

}
