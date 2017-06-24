package com.retail.shop.service;


import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



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
