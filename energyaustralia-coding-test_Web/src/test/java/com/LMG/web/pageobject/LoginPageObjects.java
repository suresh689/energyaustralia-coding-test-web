package com.LMG.web.pageobject;

import gherkin.lexer.Th;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageObjects {
    public WebDriver driver;

    public LoginPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "Email")
    private WebElement email;

    @FindBy(id="Password")
    private WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    private WebElement loginBtn;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement logoutLink;

    @FindBy(xpath = "//img[@class='jss59']")
    private  WebElement countryChange;

    @FindBy(xpath = "//div/div[contains(text(),'Egypt')]")
    private WebElement egypt;

    public void setUserName(String uname){
        email.clear();
        email.sendKeys(uname);
    }
    public void serPassword(String pwd){
        password.clear();
        password.sendKeys(pwd);
    }
    public void click_on_Login() throws InterruptedException {
        loginBtn.click();
        Thread.sleep(5000);
    }
    public void verifyTittle(String tittle){
        if(driver.getPageSource().contains("Login was unsuccessful."))
        {
            driver.close();
            Assert.assertTrue(false);
        }else{
            Assert.assertEquals(tittle,driver.getTitle());
        }
    }
    public void closeAlert(){
        driver.switchTo().alert().accept();
        //driver.switchTo().window(default);
    }
    public void clickOnLogout(){

        logoutLink.click();

    }
    public void countryChange() throws InterruptedException {
        countryChange.click();
        Thread.sleep(5000);


    }
    public void countryChangetoEgypt() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(egypt).click().build().perform();
        Thread.sleep(5000);

    }
}
