package com.retail.shop;



import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

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
}

