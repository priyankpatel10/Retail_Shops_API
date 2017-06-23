package com.retail.shop;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface ShopDAO {
	
	public Map<String, Shop> addAllShops();
	public Shop addShop(Shop shop);
	public Shop updateShop(Shop shop);
	

}
