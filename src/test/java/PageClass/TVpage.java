package PageClass;

import WebUtils.Webaction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TVpage extends Webaction {
    public TVpage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@title='LG LCD']/../following-sibling::div//a[text()='Add to Wishlist']")
    private WebElement LG_LCD_addToWishlist;

    public void cliCkONAddToWishlist(){
        waitAndClick(LG_LCD_addToWishlist);
    }
}
