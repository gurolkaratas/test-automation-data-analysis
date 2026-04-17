package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserAPI {
    public Response createUser(String username, String password){

        String body = "{\n" +
                "\"userName\": \""+username+"\",\n" +
                "\"password\": \""+password+"\"\n" +
                "}";

        return given()
                .header("Content-Type","application/json")
                .body(body)
                .when()
                .post("/Account/v1/User")
                .then()
                .extract()
                .response();
    }

    public Response generateToken(String username, String password) {

        String body = "{\n" +
                "\"userName\": \"" + username + "\",\n" +
                "\"password\": \"" + password + "\"\n" +
                "}";

        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .body(body)
                        .when()
                        .post("/Account/v1/GenerateToken");

        return response;
    }
}
