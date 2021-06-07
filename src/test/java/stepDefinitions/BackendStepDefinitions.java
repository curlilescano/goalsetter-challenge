package stepDefinitions;

import com.google.gson.JsonObject;
import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.json.Json;
import org.testng.Assert;


import static io.restassured.RestAssured.*;

public class BackendStepDefinitions {

    @Given("^I send a POST request to /auth/credentials and I print the token$")
    public void iSendPOSTToAuth() {
        RestAssured.baseURI = "https://qa-api.goalsetter.co/auth/credentials";
        RequestSpecification request = RestAssured.given();

        JsonObject requestParams = new JsonObject();
        requestParams.addProperty("email", "qa+teenEmailc242a65e1@goalsetter.co");
        requestParams.addProperty("password", "Password1");
        request.header("Content-Type", "application/json");
        request.body(requestParams.toString());
        Response response = request.post();
        Assert.assertEquals(response.statusCode(), 200);
        String token = response.jsonPath().get("token");
        System.out.println(token);
    }

}
