package com.retail.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.error.ShouldContainPattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@PropertySource("constants.properties")
public class ShopDAOImpl implements ShopDAO {
	
	Map<String, Shop> shopMap = new HashMap<String, Shop>();
	
	public Shop addShop(Shop shop){
		if(shop!=null){
			
				shopMap.put(shop.getShopName(), new Shop(shop.getShopName(),shop.getShopAddress(),shop.getShopPostCode(),shop.getLatitude(),shop.getLongitude()));
		}	
		return shopMap.get(shop.getShopName()) ;
		}
	

	@Override
	public Map<String, Shop> addAllShops() {
		shopMap.put("KFC", new Shop("KFC","Pune","123456","17.12345","18.12345"));
		shopMap.put("MCD", new Shop("MCD","Mumbai","123456","17.12345","18.12345"));
		shopMap.put("DMZ", new Shop("DMZ","Delhi","123456","17.12345","18.12345"));
		// TODO Auto-generated method stub
		return shopMap;
		
	}

	@Override
	public Shop updateShop(Shop shop) {
		if(shop!=null){
			if(shopMap.containsKey(shop.getShopName())){
				shopMap.replace(shop.getShopName(), shopMap.get(shop.getShopName()), new Shop(shop.getShopName(),shop.getShopAddress(),shop.getShopPostCode(),shop.getLatitude(),shop.getLongitude()));
			}
			
		}
		return shopMap.get(shop.getShopName());
	}

}
