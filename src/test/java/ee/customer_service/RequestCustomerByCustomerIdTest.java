package ee.customer_service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RequestCustomerByCustomerIdTest {

    @Test
    public void getCostumerByIdOK() {
        RestAssured.baseURI = "http://localhost:8080/customer";

        given()
            .contentType(ContentType.JSON)
            .pathParam("id", "1")
        .when()
            .get("/requestById/{id}")
        .then()
            .statusCode(200)
            .assertThat()
                //.body("firstname", equalTo("Epp"))
                //.body("lastname", equalTo("Lahme"))
                .body("email", equalTo("epp.lahme@gmail.com"))
                .body("marketingConsent", equalTo(false))
            .log()
            .all();

    }
    @Test
    public void getCostumerByIdNotFound() {
        RestAssured.baseURI = "http://localhost:8080/customer";

        given()
            .contentType(ContentType.JSON)
            .pathParam("id", "900")
        .when()
            .get("/requestById/{id}")
        .then()
             .statusCode(404)
             .log()
             .all();
    }
}
