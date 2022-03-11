//package com.ttbbank.oneapp.scenario.primarybanking2.API;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.tmb.automation.primarybanking2.APITest.SettingFavorite.CustomerFavoriteListResponse;
//import com.tmb.automation.primarybanking2.APITest.SettingFavorite.FavItem;
//import com.tmb.automation.primarybanking2.APITest.SettingFavorite.ViewFavoriteList;
//import com.tmb.automation.primarybanking2.Utility.GenerateToken;
//import io.restassured.path.json.JsonPath;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.List;
//import java.util.stream.Stream;
//
//public class APIViewFavList {
//
//    //public Object dataNode;
//
//      //public CustomerFavoriteListResponse customerFavoriteListResponse;
//
//    @Test
//    public void Test() throws JsonProcessingException {
//        CustomerFavoriteListResponse custFavResponse =
//                ViewFavoriteList.InquiryFavoriteList(GenerateToken.generateToken());
//
//        ObjectMapper mapper = new ObjectMapper();
//
//            //ConnectToDB connectToDB = new ConnectToDB();
//
//            //connectToDB.connectToDB()
//
//            //new ConnectToDB().connectToDB() short hand ใช้ได้แค่ครั้งเดียว
//            //learn more generic <T>
//
//            //HashMap<String, String> resultSetHashMap = new ConnectToDB().connectToDB();
//
//
//            //String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataNode);
//
//            //CustomerFavoriteListResponse custFavResponse = mapper.readValue(json, CustomerFavoriteListResponse.class);
//            List<FavItem> billers = custFavResponse.getBiller();
//            for (FavItem favItem : billers) {
//                System.out.println("Biller com_code:" + favItem.getBillerComCode());
//            }
//            //object,index,value
//            String billerCompCode = custFavResponse.getBiller().get(0).getBillerComCode();
//            System.out.println("billerCompCode :" + billerCompCode);
////
////            Stream.concat(custFavResponse.getTransfer().stream(), custFavResponse.getBiller().stream(), custFavResponse.getTopup().stream())
////                    .forEach(favItem -> Assert.assertTrue(resultSetHashMap.containsKey(favItem.getBillerComCode().toLowerCase())));
//
//    }
//}
