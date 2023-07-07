package com.LMG.web.pageobject;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePageObjects {

    public WebDriver driver;

    public HomePagePageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "/html/body/app-root/app-festivals")
    private WebElement allFestivals;

    public void verifyHeader() {
        String expectedTittle="EaCoding Test";
        String actualTittle=driver.getTitle();
        SoftAssertions sa =new SoftAssertions();
        sa.assertThat(actualTittle).isEqualTo(expectedTittle);
        sa.assertAll();
    }

    public void verifyFestivals() {
        boolean status=allFestivals.isDisplayed();
        if(status){
            System.out.print("festivals are displayed");
        }else{
            System.out.print("festivals are not displayed");
        }
    }
}
