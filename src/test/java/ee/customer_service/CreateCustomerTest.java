package ee.customer_service;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class CreateCustomerTest {

    @Test
    public void createCustomer() {
        RestAssured.baseURI = "http://localhost:8080/customer";

        JSONObject requestParams = new JSONObject();
        requestParams.put("firstName", "Jason1");
        requestParams.put("lastName", "Agile2");
        requestParams.put("email", "jason@sim3ple.eu");
        requestParams.put("marketingConsent", "true");

        given()
                .header("Content-Type","application/json")
                .and()
                .body(requestParams.toJSONString())
                .when()
                .post("/create")
                .then()
                    .statusCode(200)
                    .log().all();
    }

    @Test
    public void createCustomerWithInvalidData() {
        RestAssured.baseURI = "http://localhost:8080/customer";

        JSONObject requestParams = new JSONObject();
       // requestParams.put("firstName", "Jason1");
        //requestParams.put("lastName", "Agile2");
        requestParams.put("email", "jason@sim3ple.eu");
        requestParams.put("marketingConsent", "true");

        given()
                .header("Content-Type","application/json")
                .and()
                .body(requestParams.toJSONString())
                .when()
                .post("/create")
                .then()
                .statusCode(400) //should respond with Bad request, undocumented
                .log().all();
    }

}
