package PageClass;

import WebUtils.Webaction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Welcomepage extends Webaction {


    public Welcomepage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='page-title']")
    private WebElement cartMessage;
    @FindBy(xpath = "//span[text()='Close Window']")
    private WebElement closeWindowButton;

    public String getCartEmptyMessage(){
      return  waitAndGetValue(cartMessage);
    }
    public void closePopupWindow() throws InterruptedException {
        waitAndClick(closeWindowButton);
    }
}
