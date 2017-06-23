package com.retail.shop;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface ShopService {
	public  Shop addShop(Shop shop);
	public Map<String, Shop> addAllShops();
	public Shop updateShop(Shop shop);
	

}
