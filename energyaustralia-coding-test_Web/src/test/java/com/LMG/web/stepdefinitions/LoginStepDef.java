package com.LMG.web.stepdefinitions;

import com.LMG.web.pageobject.LoginPageObjects;
import com.LMG.web.utilities.MyScreenRecorder;
import cucumber.api.java.en.*;
import cucumber.api.java.hu.Ha;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.URI;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class LoginStepDef {
    WebDriver driver;
    LoginPageObjects lpo;

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

        WebDriverWait mywait=new WebDriverWait(driver,2);
        mywait.until(ExpectedConditions.alertIsPresent());
        Alert alt=driver.switchTo().alert();
        alt.sendKeys("LMG_QA");

        System.out.print(driver.getPageSource().contains("Help"));

    }

    @Then("^User enters Email as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_enters_Email_as_and_password_as(String uname, String password)  {
        lpo=new LoginPageObjects(driver);
        lpo.setUserName(uname);
        lpo.serPassword(password);


    }

    @And("^Click on Login$")
    public void click_on_Login()throws InterruptedException{
        lpo=new LoginPageObjects(driver);
        lpo.click_on_Login();
    }

    @Then("^Page Title should be \"([^\"]*)\"$")
    public void page_Title_should_be(String tittle1){
        lpo=new LoginPageObjects(driver);
        lpo.verifyTittle(tittle1);
    }

    @When("^User click on Logout Link$")
    public void user_click_on_Logout_Link() {
        lpo=new LoginPageObjects(driver);

        lpo.clickOnLogout();

    }

    @Then("^Page Tittle should be \"([^\"]*)\"$")
    public void page_Tittle_should_be(String tittle2){
        lpo=new LoginPageObjects(driver);
        lpo.verifyTittle(tittle2);
    }

    @And("^close browser$")
    public void close_browser() throws Exception {
        //MyScreenRecorder.stopRecording();

        //driver.close();
        //ScreenRecorderUtil.stopRecord();
    }

    @Then("^Click on country switcher$")
    public void click_on_country_switcher() throws InterruptedException {
        lpo=new LoginPageObjects(driver);
        lpo.countryChange();
        lpo.countryChangetoEgypt();
        Actions act=new Actions(driver);
        WebElement logo=driver.findElement(By.xpath("//*[@id=\"page-header\"]/a/span/img"));
//        act.contextClick(logo).perform();
//        .keyDown(Keys.LEFT_CONTROL)
//                .click(element)
        act.
                moveToElement(logo)
                .keyDown(Keys.COMMAND)
                .click()
                .keyUp(Keys.COMMAND)
                .build()
                .perform();

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        lpo.countryChange();
        lpo.countryChangetoEgypt();


    }
}
