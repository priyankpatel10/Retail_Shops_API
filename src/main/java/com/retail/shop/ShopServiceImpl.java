package com.retail.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
	
	

}
