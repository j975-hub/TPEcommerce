package PageClass;

import WebUtils.Webaction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

import javax.xml.xpath.XPath;

public class UserRegistrationpage extends Webaction {

    WebDriver driver;
    public UserRegistrationpage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    By firstName = By.xpath("//label[text()='First Name']");
    By middleName = By.xpath("//label[text()='Middle Name/Initial']");
    By lastName = By.xpath("//label[text()='Last Name']");
    By emailAddress = By.xpath("//label[text()='Email Address']");
    By password = By.xpath("//label[text()='Password']");
    By confirmPassword = By.xpath("//label[text()='Confirm Password']");




    By tagName = By.tagName("input");
    By confirmation = By.name("confirmation");

    public void enterFirstName(String text) {
       WebElement element = driver.findElement(RelativeLocator.with(tagName).below(driver.findElement(firstName)));
       waitAndSendKeys(element,text);
    }
    public void enterLastName(String text){
        WebElement element = driver.findElement(RelativeLocator.with(tagName).below(driver.findElement(lastName)));
        waitAndSendKeys(element,text);
    }
    public void enterEmailAddress(String text){
        WebElement element = driver.findElement(RelativeLocator.with(tagName).below(driver.findElement(emailAddress)));
        waitAndSendKeys(element,text);
    }
    public void enterPassword(String text) throws InterruptedException {
        WebElement element = driver.findElement(RelativeLocator.with(tagName).below(driver.findElement(password)));
        waitAndSendKeys(element,text);
        Thread.sleep(2000);
    }
    public void enterConfirmPassword(String text){
        WebElement element = driver.findElement(RelativeLocator.with(confirmation).below(driver.findElement(confirmPassword)));
        waitAndSendKeys(element,text);
    }
}
