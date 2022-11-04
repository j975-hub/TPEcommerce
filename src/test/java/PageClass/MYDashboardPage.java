package PageClass;

import WebUtils.Webaction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MYDashboardPage extends Webaction {
    public MYDashboardPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//ul[@class='messages']")
    private WebElement successMessage;
    @FindBy(xpath = "//button[@title='Share Wishlist']")
    private WebElement shareWishlistButton;
    @FindBy(xpath = "//textarea[@id='email_address']")
    private WebElement emailTextArea;
    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement messageTextArea;


    public String getSuccessMessage(){
       return waitAndGetValue(successMessage);
    }
    public void clickOnShareWishlistButton(){
        waitAndClick(shareWishlistButton);
    }
    public void sendEmail(String text){
        waitAndSendKeys(emailTextArea,text);
    }
    public void sendMessage(String text){
        waitAndSendKeys(messageTextArea,text);
    }

}
