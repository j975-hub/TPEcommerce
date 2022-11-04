package TestClass;

import WebUtils.InstanceSetup;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;


public class Testcase5 {

    InstanceSetup instanceSetup;
    String jsonFileName = "Testcase5";

    public void openBrowser() throws IOException {
        instanceSetup = new InstanceSetup();
    }
    @Test(groups = "Smoke")
    public void createNewAccount() throws InterruptedException {
        try{
            openBrowser();
            instanceSetup.pageobjectmanager.goToHomepage().clickOnMyAccountLink();
            instanceSetup.pageobjectmanager.goToHomepage().createAccount();
        }catch (Exception e){
            System.out.println("Exception: "+ e.getMessage());
        } try {
            instanceSetup.pageobjectmanager.goToUserRegisterationpage().enterFirstName(enterData("FirstName"));
            instanceSetup.pageobjectmanager.goToUserRegisterationpage().enterLastName(enterData("LastName"));
            instanceSetup.pageobjectmanager.goToUserRegisterationpage().enterEmailAddress(enterData("EmailID"));
            instanceSetup.pageobjectmanager.goToUserRegisterationpage().enterPassword(enterData("Password"));
            instanceSetup.pageobjectmanager.goToUserRegisterationpage().enterConfirmPassword(enterData("ConfirmPassword"));
            instanceSetup.pageobjectmanager.goToHomepage().clickOnRegisterButton();
        }catch (Exception e){
            System.out.println("Exception: "+ e.getMessage());
        } try {
           String registerMessage = instanceSetup.pageobjectmanager.goToMyDashboardPage().getSuccessMessage();
           System.out.println(registerMessage);
            Assert.assertEquals(registerMessage,"Thank you for registering with Main Website Store.");
           instanceSetup.pageobjectmanager.goToHomepage().clickOnTVmenu();
           instanceSetup.pageobjectmanager.goToTVpage().cliCkONAddToWishlist();
           instanceSetup.pageobjectmanager.goToMyDashboardPage().clickOnShareWishlistButton();
           instanceSetup.pageobjectmanager.goToMyDashboardPage().sendEmail(enterData("SendEmail"));
           instanceSetup.pageobjectmanager.goToMyDashboardPage().sendMessage(enterData("SendMessage"));
           instanceSetup.pageobjectmanager.goToMyDashboardPage().clickOnShareWishlistButton();
           String wishListMessage = instanceSetup.pageobjectmanager.goToMyDashboardPage().getSuccessMessage();
            System.out.println(wishListMessage);
            Assert.assertEquals(wishListMessage,"Your Wishlist has been shared.");
        } catch (Exception e){
            System.out.println("Exception: "+ e.getMessage());
        }finally {
            Thread.sleep(3000);
            instanceSetup.driver.quit();
        }
    }
    public String enterData(String text) throws IOException {
      return  instanceSetup.getJsonResponse(jsonFileName).get(text);
    }
}
