package WebUtils;

import PageClass.*;
import org.openqa.selenium.WebDriver;

public class Pageobjectmanager {

    WebDriver driver;

    Pageobjectmanager(WebDriver driver){
        this.driver=driver;
    }

    public Homepage goToHomepage(){
        Homepage homepage = new Homepage(driver);
        return homepage;
    }
    public Mobilepage goToMobilepage(){
        Mobilepage mobilepage = new Mobilepage(driver);
        return mobilepage;
    }
    public Shoppingcartpage goToShoppingCartPage(){
       Shoppingcartpage shoppingcartpage = new Shoppingcartpage(driver);
       return shoppingcartpage;
    }
    public Welcomepage goToWelcomePage(){
        Welcomepage welcomepage = new Welcomepage(driver);
        return  welcomepage;
    }
    public UserRegistrationpage goToUserRegisterationpage(){
        UserRegistrationpage userRegistrationpage = new UserRegistrationpage(driver);
        return userRegistrationpage;
    }
    public MYDashboardPage goToMyDashboardPage(){
        MYDashboardPage myDashboardPage = new MYDashboardPage(driver);
        return myDashboardPage;
    }
    public TVpage goToTVpage(){
        TVpage tVpage = new TVpage(driver);
        return tVpage;
    }
}
