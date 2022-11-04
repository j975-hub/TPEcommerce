package PageClass;

import WebUtils.Webaction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Mobilepage extends Webaction {

    public Mobilepage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[text()='Sony Xperia']/../following-sibling::div//span[@class='price']")
    private WebElement sonyXperiaMobileCost;
    @FindBy(xpath = "//a[text()='Sony Xperia']/../following-sibling::div//button[@title='Add to Cart']")
    private WebElement sonyXperiaAddToCart;
    @FindBy(xpath = "//a[text()='Sony Xperia']/../following-sibling::div//a[text()='Add to Compare']")
    private WebElement sonyXperiaAddToCompare;
    @FindBy(xpath = "//a[text()='IPhone']/../following-sibling::div//a[text()='Add to Compare']")
    private WebElement iphoneAddToCompare;
    @FindBy(xpath = "//span[text()='Compare']")
    private WebElement compareButton;

    public String getSonyXperiaMobileCostInDetailsPage(){
       return waitAndGetValue(sonyXperiaMobileCost);
    }
    public void clickOnSonyXperiaAddToCart(){
        waitAndClick(sonyXperiaAddToCart);
    }
    public void clickOnSonyXperiaAddToCompare(){
        waitAndClick(sonyXperiaAddToCompare);
    }
    public void clickOnIphoneAddToCompare(){
        waitAndClick(iphoneAddToCompare);
    }
    public void clickOnCompareButton() throws IOException {
        waitAndClick(compareButton);
        handlingWindows();
        customizeScreenShotCapture("ProductValidation");
    }
}
