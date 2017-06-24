# Retail_Shops_API
A Retail Manager wanting to keep track of their shops, does a RESTful POST to /shops with a JSON to the Shops API (microservice) where shops are stored in memory.The Google Maps API responds with the longitude and latitude, which allows the shop data to be updates with longitude and latitude. A customer, using their geolocation on their phone, wants to find the store that is closest to them.

#Endpoints Urls
1) localhost:8080/shops - To add or update the shop using JSON parameters as follows,
 {
  	"shopName": "KFC pune",
    "shopAddress": "Pune 411044",
    "shopPostCode": "411044"
 }
 
 2) localhost:8080/getShop/latitude/longitude - To get the nearest shop for eg. as follows,
 
 localhost:8080/getShop/23.02642590/72.58434140
 
#Database Info
It has an in memory db, but just in case if anyone hit the "/getShop" url first, or to test the edit/update shop details, there were
three entries are added every time when program starts. Those three sample entries are as follows,
1)  {
    "shopName": "KFC delhi",
    "shopAddress": "Delhi",
    "shopPostCode": "110005",
    "latitude": "28.7041",
    "longitude": " 77.1025"
}
    
2)  {
    "shopName": "KFC pune",
    "shopAddress": "Pune",
    "shopPostCode": "411004",
    "latitude": "18.5204",
    "longitude": "73.8567"
}
    
3)  {
    "shopName": "MCD mumbai",
    "shopAddress": "Mumbai",
    "shopPostCode": "400001",
    "latitude": "19.0760",
    "longitude": "72.8777"
}
