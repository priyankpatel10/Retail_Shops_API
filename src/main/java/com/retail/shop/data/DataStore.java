package com.retail.shop.data;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.maps.model.LatLng;
import com.retail.shop.model.Shop;



public class DataStore implements ShopList<Shop, LatLng> {

	
	private static final Logger LOG = Logger.getLogger(DataStore.class.getName());

	private final List<Shop> data = new ArrayList<>();

	@Override
	public Shop get(LatLng geocode) {
		Shop nearestShop = findNearest(geocode);
		return nearestShop;
	}

	/**
	 * get all the registered shops
	 */
	@Override
	public List<Shop> getAll() {
		return data;
	}

	/**
	 * register a shop
	 */
	@Override
	public Shop add(Shop item) {
		data.add(item);
		return item;
	}

	/**
	 * Find the shop nearest to this geocode
	 * 
	 * @param geocode
	 * @return
	 */
	public Shop findNearest(LatLng geocode) {
		// customer latitude and longitude
		double lat1 = geocode.lat;
		double lon1 = geocode.lng;
		// hold the nearest distance found till now
		double nearestDist = -1;
		// hold the reference to the nearest shop found till now
		Shop nearestShop = null;
		for (Shop shop : data) {
			// latitude and longitude of the shop to compare
			double lat2 = Double.parseDouble(shop.getLatitude());
			double lon2 = Double.parseDouble(shop.getLongitude());
			// distance to the shop in comparison
			double dist = DataUtil.haversine(lat1, lon1, lat2, lon2);
			// if the shop in comparison is nearer than the previous shop or if
			// it is the first shop
			if (dist < nearestDist || nearestDist == -1) {
				nearestShop = shop;
				nearestDist = dist;
				LOG.log(Level.INFO, " Shop " + nearestShop.getShopName() + " found at " + nearestDist + " KM");
			}
		}
		return nearestShop;
	}

}
