package PageClass;

import WebUtils.Webaction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Homepage extends Webaction {

    public Homepage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[text()='Mobile']")
    private WebElement mobileLink;
    @FindBy(xpath = "//select[@title='Sort By']")
    private WebElement sortingDropdown;
    @FindBy(xpath = "//a[text()='Sony Xperia']/../following-sibling::div//span[@class='price']")
    private WebElement sonyXperiaPrice;
    @FindBy(xpath = "//a[text()='Sony Xperia']")
    private WebElement sonyXperiaItem;
    @FindBy(xpath = "//div[@class='footer-container']//a[text()='My Account']")
    private WebElement myAccountLink;
    @FindBy(xpath = "//span[text()='Create an Account']/../..")
    private WebElement createAccountLink;
    @FindBy(xpath = "//button[@title='Register']")
    private WebElement registerButton;
    @FindBy(xpath = "//a[text()='TV']/..")
    private WebElement tvLink;

    public void clickOnMobileMenu(){
        waitAndClick(mobileLink);
    }
    public void sortingBy(String text) throws IOException {
        selectClassElement(sortingDropdown,text);
        customizeScreenShotCapture(text,sortingDropdown);
    }
    public String getSonyXperiaMobileCostInListPage(){
      return  waitAndGetValue(sonyXperiaPrice);
    }
    public void clickOnSonyXperiaMobileLink(){
        waitAndClick(sonyXperiaItem);
    }
    public void clickOnMyAccountLink(){
        waitAndClick(myAccountLink);
    }
    public void createAccount(){
        waitAndClick(createAccountLink);
    }
    public void clickOnRegisterButton(){
        waitAndClick(registerButton);
    }
    public void clickOnTVmenu(){
        waitAndClick(tvLink);
    }
}
