package ee.customer_service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
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

    /*
    * This test covers, if request body is correct
    * and CSV migration to db was success
    */
    @Test
    public void getCostumerByIdValidateResponseBody() {
        RestAssured.baseURI = "http://localhost:8080/customer";

        RequestSpecification httpRequest = RestAssured.given().log().all();
        Response response = httpRequest.get("/requestById/1");
        ResponseBody body = response.getBody();
        String bodyStringValue = body.asString();
        // Validate if Response Body Contains a specific String
        Assert.assertTrue(bodyStringValue.contains("Epp"));
        Assert.assertTrue(bodyStringValue.contains("Lahme"));
        Assert.assertTrue(bodyStringValue.contains("epp.lahme@gmail.com"));
        Assert.assertTrue(bodyStringValue.contains("marketingConsent"));

    }
}
