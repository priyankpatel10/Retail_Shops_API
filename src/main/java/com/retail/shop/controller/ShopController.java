package com.retail.shop.controller;



import java.util.HashMap;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.retail.shop.model.Shop;
import com.retail.shop.service.ShopService;


@RestController
@ComponentScan("com.retail.*")
public class ShopController {

	@Autowired
	ShopService shopService;
	
	
	
	
	@Value("${com.retail.shop.previousAddress}")
	private String previousAdress;
	@Value("${com.retail.shop.currentAddress}")
	private String currentAddress;
	@Value("${com.retail.shop.newShopAdded}")
	private String newShopAdded;
	

		  
	 
    @RequestMapping(value="/shops", method=RequestMethod.POST, consumes= "application/json")
    @ResponseBody
    public Map<String,Shop> addShop(@RequestBody Shop shop) {
    	Map<String, Shop> initialShopMap = shopService.addAllShops();
    	Map<String, Shop> finalShopMap = new HashMap<String, Shop>();
    	if(initialShopMap.containsKey(shop.getShopName())){	
    		finalShopMap.put(previousAdress,initialShopMap.get(shop.getShopName()));
    		Shop updatedShop = shopService.updateShop(shop);
    		finalShopMap.put(currentAddress, updatedShop);
    		return finalShopMap;
    		
    	}
    	 Shop newShop = shopService.addShop(shop);
    	 finalShopMap.put(newShopAdded, newShop);
       return finalShopMap;
    }
    
    @RequestMapping(path = "/getShop/{latitude}/{longitude}", method = RequestMethod.GET)
    @ResponseBody
	public Shop getShop(@PathVariable double latitude, @PathVariable double longitude ) {
    	Map<String, Shop> initialShopMap = shopService.addAllShops();
		Shop nearestShop = shopService.getShop(latitude,longitude);
		return nearestShop;
	}
}