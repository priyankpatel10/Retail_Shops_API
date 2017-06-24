package com.retail.shop;



import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.google.maps.model.LatLng;
import com.retail.shop.data.DataStore;
import com.retail.shop.data.ShopList;
import com.retail.shop.model.Shop;
import com.retail.shop.util.LocationService;



@SpringBootApplication
public class ShopMain {

    public static void main(String[] args) {
        SpringApplication.run(ShopMain.class, args);
    }
    
    @Bean(name = "locationService")
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	@ConfigurationProperties(prefix = "config")
	public LocationService getLocationService() {
    	LocationService service = new LocationService();
		return service;
	}
    
    @Bean(name = "dataStore")
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public ShopList<Shop, LatLng> getDataStore() {
		return new DataStore();
	}
}

