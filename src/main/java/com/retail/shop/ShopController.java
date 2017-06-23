package com.retail.shop;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShopController {


    @RequestMapping(value="/shops", method=RequestMethod.POST, consumes= "application/json")
    @ResponseBody
    public  Shop addShop(@RequestBody Shop shop) {
    	
        return new Shop(shop.getShopName(),shop.getShopAddress(),shop.getShopPostCode(),shop.getLongitude(),shop.getLatitude());
    }


}