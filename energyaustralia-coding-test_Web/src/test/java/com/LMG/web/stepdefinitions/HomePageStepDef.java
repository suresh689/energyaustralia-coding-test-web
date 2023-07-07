package com.LMG.web.stepdefinitions;

import com.LMG.web.pageobject.HomePagePageObjects;
import com.LMG.web.utilities.MyScreenRecorder;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class HomePageStepDef {
    WebDriver driver;
    HomePagePageObjects hpo;

    @Given("^User Launch Browser$")
    public void user_Launch_Browser() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MyScreenRecorder.startRecording("user_Launch_Browser");
    }

    @When("^User open URL \"([^\"]*)\"$")
    public void user_open_URL(String url) throws AWTException, InterruptedException {

        driver.get(url);

    }

    @And("^close browser$")
    public void close_browser() throws Exception {
        driver.close();
    }

    @Then("^Verify user landed to Home page$")
    public void verifyUserLandedToHomePage() {
        hpo=new HomePagePageObjects(driver);
        hpo.verifyHeader();
    }

    @And("^Verify festivals displayed$")
    public void verifyFestivalsDisplayed() {
        hpo=new HomePagePageObjects(driver);
        hpo.verifyFestivals();
    }
}
