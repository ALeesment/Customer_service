package ee.customer_service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SetMarketingConsentToCustomerTest {
    @Test
    public void setCostumerByIdOK() {
        RestAssured.baseURI = "http://localhost:8080/customer";

        given().log()
                .all()
                .contentType(ContentType.JSON)
                .pathParam("id", "1")
                .queryParam("marketingConsent", true)
                .when()
                .put("/marketingConsent/{id}")
                .then()
                .statusCode(200).log().all()
                ;



    }
}
