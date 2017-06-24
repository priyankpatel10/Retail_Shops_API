package com.retail.shop.model;

import org.springframework.stereotype.Component;

@Component
public class Shop {
	private String shopName;
	private String shopAddress;
	
	public Shop() {
	
		// TODO Auto-generated constructor stub
	}

	private String shopPostCode;
	private String latitude;
	private String longitude;
	
	public Shop(String shopName, String shopAddress, String shopPostCode, String latitude, String longitude) {
		super();
		this.shopName = shopName;
		this.shopAddress = shopAddress;
		this.shopPostCode = shopPostCode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getShopPostCode() {
		return shopPostCode;
	}

	public void setShopPostCode(String shopPostCode) {
		this.shopPostCode = shopPostCode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	
	

}
