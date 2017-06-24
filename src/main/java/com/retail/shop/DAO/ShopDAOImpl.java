package com.retail.shop.DAO;


import java.util.HashMap;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Component;


import com.google.maps.model.LatLng;
import com.retail.shop.data.ShopList;
import com.retail.shop.model.Shop;
import com.retail.shop.util.LocationService;


@Component
public class ShopDAOImpl implements ShopDAO {
	@Autowired
	@Qualifier("locationService")
	LocationService locationService;
	
	@Autowired
	@Qualifier("dataStore")
	private ShopList<Shop, LatLng> shopList;
	
	Map<String, Shop> shopMap = new HashMap<String, Shop>();
	
	public Shop addShop(Shop shop){
		if(shop!=null){
				LatLng latlng = locationService.getGeocode(shop);
				shop.setLatitude(latlng.toString().split(",")[0]);
				shop.setLongitude(latlng.toString().split(",")[1]);
				shopList.add(shop);
				shopMap.put(shop.getShopName(), new Shop(shop.getShopName(),shop.getShopAddress(),shop.getShopPostCode(),shop.getLatitude(),shop.getLongitude()));
				shopList.add(new Shop(shop.getShopName(),shop.getShopAddress(),shop.getShopPostCode(),shop.getLatitude(),shop.getLongitude()));
		}	
		return shopMap.get(shop.getShopName()) ;
		}
	

	@Override
	public Map<String, Shop> addAllShops() {
		shopMap.put("KFC pune", new Shop("KFC pune","Pune","411004","18.5204", "73.8567"));
		shopList.add(new  Shop("KFC pune","Pune","411004","18.5204", "73.8567"));
		shopMap.put("MCD mumbai", new Shop("MCD mumbai","Mumbai","400001","19.0760","72.8777"));
		shopList.add( new Shop("MCD mumbai","Mumbai","400001","19.0760","72.8777"));
		shopMap.put("KFC delhi", new Shop("KFC delhi","Delhi","110005","28.7041" ," 77.1025"));
		shopList.add(new Shop("KFC delhi","Delhi","110005","28.7041" ," 77.1025"));
		// TODO Auto-generated method stub
		
		return shopMap;
		
	}

	@Override
	public Shop updateShop(Shop shop) {
		if(shop!=null){
			if(shopMap.containsKey(shop.getShopName())){
				LatLng latlng = locationService.getGeocode(shop);
				shop.setLatitude(latlng.toString().split(",")[0]);
				shop.setLongitude(latlng.toString().split(",")[1]);
				shopMap.replace(shop.getShopName(), shopMap.get(shop.getShopName()), new Shop(shop.getShopName(),shop.getShopAddress(),shop.getShopPostCode(),shop.getLatitude(),shop.getLongitude()));
				shopList.add(new Shop(shop.getShopName(),shop.getShopAddress(),shop.getShopPostCode(),shop.getLatitude(),shop.getLongitude()));
			}
			
		}
		return shopMap.get(shop.getShopName());
	}
	
	public Shop getShop(  double latitude,  double longitude){
		LatLng geocode = new LatLng(latitude, longitude);
			Shop nearestShop = shopList.get(geocode);
			return nearestShop;
		
	}

}
