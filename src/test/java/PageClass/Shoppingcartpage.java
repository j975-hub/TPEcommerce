package PageClass;

import WebUtils.Webaction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shoppingcartpage extends Webaction {

    public Shoppingcartpage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@title='Qty']")
    private WebElement productQuantity;
    @FindBy(xpath = "//button[@title='Update']")
    private WebElement updateButton;
    @FindBy(xpath = "//p[@class='item-msg error']")
    private WebElement errorMessage;
    @FindBy(xpath = "//span[text()='Empty Cart']")
    private WebElement emptyCartLink;

    public void selectProductQuantity(String text){
        waitAndSendKeys(productQuantity,text);
    }
    public void clickOnUpdateButton(){
        waitAndClick(updateButton);
    }
    public String getItemErrorMessage(){
      return  waitAndGetValue(errorMessage);
    }
    public void clickOnEmptyCartLink(){
        waitAndClick(emptyCartLink);
    }

}
