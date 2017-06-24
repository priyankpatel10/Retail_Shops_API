package com.retail.shop.DAO;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.retail.shop.model.Shop;

@Repository
public interface ShopDAO {
	
	public Map<String, Shop> addAllShops();
	public Shop addShop(Shop shop);
	public Shop updateShop(Shop shop);
	

}
