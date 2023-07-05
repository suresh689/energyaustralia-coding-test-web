package com.LMG.API.utilities;

import com.google.gson.JsonObject;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.TextStyle;
import java.util.*;

public class ReusableMethods {
    public static String authorization="Authorization";
    public static String xContextRequest="X-Context-Request";
    public static String bearer="Bearer ";
    public static String xIgnoreTranslations="X-Ignore-Translations";
    public static String acceptLanguage="Accept-Language";
    public static String xForwadedFor="X-Forwaded-For";
    public static String userAgent="User-Agent";
    public static String areacode="areacode";
    public static String clientId="client_id";
    public static String contentType="Content-Type";
    public static String grant_type="grant_type";
    public static String username="username";
    public static String password="password";
    public static String purpose="purpose";
    public static String scope="scope";
    public static String code="code";
    public static String basic="Basic ";
    public static String client_secret="client_secret";




        public static String getGlobalValue(String val) throws IOException, IOException {
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir") +"/src/test/java/com/LMG/API/utilities/"+ "resourses.properties");
        prop.load(fis);
        return prop.getProperty(val);
    }
    public static void apiResouces() throws IOException {
            String usercode_resource=getGlobalValue(getGlobalValue("usercode_resource"));
        String accesstoke_resoruce=getGlobalValue(getGlobalValue("accesstoke_resoruce"));
        String delivery_estimate_resource=getGlobalValue(getGlobalValue("delivery_estimate_resource"));
    }
    public static List<String> getIsoCode() throws IOException {
           List<String>  isoCode= new ArrayList<String>();
            Excel xlib=new Excel();
            int lasRowNum= xlib.getLasRowNumber("Sheet1");
            for(int i=1;i<=lasRowNum;i++){
                isoCode.add(xlib.getExcelData("Sheet1", i, 2));

            }
            return isoCode;

    }
    public static List<String> deliveryEstimateDays() throws IOException {
        List<String>  deliveryEstimateDays= new ArrayList<String>();
        Excel xlib=new Excel();
        int lasRowNum= xlib.getLasRowNumber("Sheet1");
        for(int i=1;i<=lasRowNum;i++){
            deliveryEstimateDays.add(xlib.getExcelData("Sheet1", i, 1));
        }
        return deliveryEstimateDays;
    }
    public static List<String> cutOffTime() throws IOException, ParseException {
        List<String>  cutOffTime= new ArrayList<String>();
        Excel xlib=new Excel();
        int lasRowNum= xlib.getLasRowNumber("Sheet1");
        for(int i=1;i<=lasRowNum;i++){
            cutOffTime.add(xlib.getTimeValue("Sheet1", i, 0));
        }
        return cutOffTime;
    }
    public static List<String> bufferDay() throws IOException, ParseException {
        List<String>  bufferDay= new ArrayList<String>();
        Excel xlib=new Excel();
        int lasRowNum= xlib.getLasRowNumber("Sheet1");
        for(int i=1;i<=lasRowNum;i++){
            bufferDay.add(xlib.getExcelData("Sheet1", i, 7));
        }
        return bufferDay;
    }
    public static List<String> areaName() throws IOException, ParseException {
        List<String>  areaName= new ArrayList<String>();
        Excel xlib=new Excel();
        int lasRowNum= xlib.getLasRowNumber("Sheet1");
        for(int i=1;i<=lasRowNum;i++){
            areaName.add(xlib.getExcelData("Sheet1", i, 3));
        }
        return areaName;
    }
    public static RequestSpecification requestSepecification() throws IOException {

        RequestSpecification req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURI")).build();

        return  req;
    }

    public static String getResponseDeliveryEstimate(RequestSpecification reqLogin) throws IOException {

        String getResponse = reqLogin.
                when().get(getGlobalValue("delivery_estimate_resource") + "{areacode}").
                then().
                //log().all().
                statusCode(200).extract().response().asString();
            return getResponse;
    }
    public static JsonPath jsonPathResponse(String getResponse){
        JsonPath js = new JsonPath(String.valueOf(getResponse));
        return js;
    }
   // @BeforeMethod
    public static String getTime() throws IOException {
        ZoneId id = ZoneId.of ( getGlobalValue("timezone") );
        LocalTime localTime = LocalTime.now ( id );
        int hours=localTime.getHour();
        int minutes=localTime.getMinute();
        int seconds=localTime.getSecond();
        return hours+":"+minutes+":"+seconds;
    }
    public static String getDay() throws IOException {
        ZoneId id = ZoneId.of ( getGlobalValue("timezone") );
        Instant instant = Instant.now();
        ZonedDateTime zDateTime = instant.atZone(id);
        DayOfWeek day = zDateTime.getDayOfWeek();

        return day.getDisplayName(TextStyle.FULL_STANDALONE, Locale.US);
    }



}
