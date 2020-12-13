package ee.customer_service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SetMarketingConsentToCustomerTest {
    @Test
    public void setMarketingConsentOK() {
        RestAssured.baseURI = "http://localhost:8080/customer";

        given()
                .contentType(ContentType.JSON)
                .pathParam("id", "1")
                .queryParam("marketingConsent", true)
        .when()
                .put("/marketingConsent/{id}")
        .then()
                .statusCode(200).log().all();

    }

    @Test
    public void setMarketingConsentToNonExistentCustomer() {
        RestAssured.baseURI = "http://localhost:8080/customer";

        given()
                .contentType(ContentType.JSON)
                .pathParam("id", "1000")
                .queryParam("marketingConsent", true)
        .when()
                .put("/marketingConsent/{id}")
        .then()
                .statusCode(400)
                .log()
                .all();
    }
}
