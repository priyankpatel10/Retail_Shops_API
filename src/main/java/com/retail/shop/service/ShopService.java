package com.retail.shop.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.retail.shop.model.Shop;

@Service
public interface ShopService {
	public  Shop addShop(Shop shop);
	public Map<String, Shop> addAllShops();
	public Shop updateShop(Shop shop);
	public Shop getShop(  double latitude,  double longitude);
	

}
