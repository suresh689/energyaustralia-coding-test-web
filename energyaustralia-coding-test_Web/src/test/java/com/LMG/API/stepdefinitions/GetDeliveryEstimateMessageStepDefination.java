package com.LMG.API.stepdefinitions;

import com.LMG.API.utilities.Utils;
import cucumber.api.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GetDeliveryEstimateMessageStepDefination extends Utils {
    RequestSpecification req;
    ResponseSpecification res;
    Response response;
    static String access_toke;

    @Given("^select language as \"([^\"]*)\"$")
    public void select_language_as(String arg1) throws Throwable {
        //req= req.given().spec(requestSpecification());


    }

    @When("^verify delivery estimate message with \"([^\"]*)\" http request$")
    public void verify_delivery_estimate_message_with_http_request(String arg1) throws Throwable {

    }

    @Then("^The API call got success with status code$")
    public void the_API_call_got_success_with_status_code() throws Throwable {
    }

    @Then("^verify \"([^\"]*)\" with \"([^\"]*)\"$")
    public void verify_with(String arg1, String arg2) throws Throwable {
    }
}
