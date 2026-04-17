package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookStoreAPI {
    public Response getBooks(){

        return given()
                .when()
                .get("/BookStore/v1/Books")
                .then()
                .extract()
                .response();
    }

    public Response addBook(String userId, String token, String isbn){

        String body = "{\n" +
                "  \"userId\": \"" + userId + "\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \"" + isbn + "\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        return given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + token)
                .body(body)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .extract()
                .response();
    }

    public Response deleteBook(String userId, String isbn, String token) {

        String body = "{\n" +
                "  \"isbn\": \"" + isbn + "\",\n" +
                "  \"userId\": \"" + userId + "\"\n" +
                "}";

        return given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(body)
                .when()
                .delete("/BookStore/v1/Book")
                .then()
                .extract()
                .response();
    }

}
