package utils;


import io.restassured.http.ContentType;


import static io.restassured.RestAssured.*;

public class Auth {

    public static String token(){

        String email = System.getenv("EMAIL");
        String password = System.getenv("PASSWORD");

        return
                given()
                        .contentType(ContentType.JSON)
                        .body("{\"email\": \"" + email + "\",  \"password\": \"" + password + "\"}")
                .when()
                        .post("http://localhost:3000/login")
                .then()
                        .extract().response().jsonPath().getString("authorization")
                ;


    }

}
