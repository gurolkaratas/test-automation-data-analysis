package api;

import io.restassured.RestAssured;
import org.testng.Assert;

public class ApiBase {
    public static void setup(){
        RestAssured.baseURI =  "https://demoqa.com";
    }
}
