package com.LMG.web.stepdefinitions;

import cucumber.api.java.en.*;

public class CustomerStepDef {

    @Then("^User can view Dashboard$")
    public void user_can_view_Dashboard(){
    }

    @When("^User click on customers Menu$")
    public void user_click_on_customers_Menu(){
    }

    @And("^click on customer Menu Item$")
    public void click_on_customer_Menu_Item(){
    }

    @And("^click on Add new button$")
    public void click_on_Add_new_button(){
    }

    @Then("^User can view Add new customer page$")
    public void user_can_view_Add_new_customer_page(){
    }

    @When("^User enter customer info$")
    public void user_enter_customer_info(){
    }

    @And("^click on save button$")
    public void click_on_save_button(){
    }

    @Then("^User can view confirmation message \"([^\"]*)\"$")
    public void user_can_view_confirmation_message(String arg1){
    }
}
