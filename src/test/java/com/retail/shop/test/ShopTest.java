package com.retail.shop.test;

import java.net.URL;

import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;


import com.retail.shop.model.Shop;


@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
@WebAppConfiguration
@SpringBootTest({ "server.port=0" })
public class ShopTest {

	@Value("${local.server.port}")
	private int port;

	private URL base;
	private TestRestTemplate template;
	
	@Before
	public void contextLoads() {
	}
	
	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/shop");
		template = new TestRestTemplate();
	}

	@Test
	public void addShop() throws Exception {
		this.base = new URL("http://localhost:" + port + "/shops");
		Shop shop = new Shop();
		shop.setShopName("CCD pune");
		shop.setShopAddress("Mother's Kitchen, Vishal Nagar, Pimpri-Chinchwad, Maharashtra");
		shop.setShopPostCode("411038");

		ResponseEntity response = template.postForEntity(base.toString(), shop, null);

		Assert.assertEquals("The Post request should  be successful.", HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void getShop() throws Exception {
		this.base = new URL("http://localhost:" + port + "/getShop/{latitude}/{longitude}");
		Object[] requestVariables = { "18.5870610", "73.7840560" };
		ResponseEntity<Shop> response = template.getForEntity(base.toString(), Shop.class, requestVariables);

		Assert.assertEquals("The Get request should  be successful.", HttpStatus.OK, response.getStatusCode());
		Assert.assertNotNull("Should return a Shop with name.", response.getBody().getShopName());
		Assert.assertNotNull("Should return a Shop with address.",
				response.getBody().getShopAddress());
		Assert.assertNotNull("Should return a Shop with Postal Code.", response.getBody().getShopPostCode());
		Assert.assertNotNull("Should return a Shop latitude.", response.getBody().getLatitude());
		Assert.assertNotNull("Should return a Shop with longitude.", response.getBody().getLongitude());
	}
}
