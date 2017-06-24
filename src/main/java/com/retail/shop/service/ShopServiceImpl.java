package com.retail.shop.service;

import static org.mockito.Matchers.shortThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.retail.shop.DAO.ShopDAO;
import com.retail.shop.model.Shop;


@Component
public class ShopServiceImpl implements ShopService{
	
	@Autowired
	ShopDAO shopDAO;

	

	@Override
	public Map<String, Shop> addAllShops() {
		// TODO Auto-generated method stub
		Map<String, Shop> shopMap = shopDAO.addAllShops();
		return shopMap;
	}

	@Override
	public Shop addShop(Shop shop) {
		// TODO Auto-generated method stub
		Shop newShop = shopDAO.addShop(shop);
		return newShop;
	}

	@Override
	public Shop updateShop(Shop shop) {
		// TODO Auto-generated method stub
		Shop updatedShop = shopDAO.updateShop(shop);
		return updatedShop;
	}

	@Override
	public Shop getShop( double latitude,  double longitude) {
		// TODO Auto-generated method stub
		Shop nearestShop = shopDAO.getShop(latitude,longitude);
		return nearestShop;
	}
	

	

}
