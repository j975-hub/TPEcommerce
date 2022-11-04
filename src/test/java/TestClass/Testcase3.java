package TestClass;

import WebUtils.InstanceSetup;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;


public class Testcase3 {
    InstanceSetup instanceSetup;

    public void openBrowser() throws IOException {
        instanceSetup = new InstanceSetup();
    }

    @Test(groups = {"Regression"})
    public void validationOfProductAvailability() throws IOException, InterruptedException {
       try{
           openBrowser();
           instanceSetup.pageobjectmanager.goToHomepage().clickOnMobileMenu();
           instanceSetup.pageobjectmanager.goToMobilepage().clickOnSonyXperiaAddToCart();
           instanceSetup.pageobjectmanager.goToShoppingCartPage().selectProductQuantity("1000");
           instanceSetup.pageobjectmanager.goToShoppingCartPage().clickOnUpdateButton();
           String errorMessage = instanceSetup.pageobjectmanager.goToShoppingCartPage().getItemErrorMessage();
           System.out.println(errorMessage);
           instanceSetup.pageobjectmanager.goToShoppingCartPage().clickOnEmptyCartLink();
           getCartEmptyMessage();
       }catch (Exception e){
           System.out.println("Exception: " + e.getMessage());
       }finally {
           Thread.sleep(3000);
           instanceSetup.driver.quit();
       }
    }
    public void getCartEmptyMessage(){
        String cartEmptyMessage = instanceSetup.driver.findElement(By.xpath("//div[@class='page-title']")).getText().trim();
        System.out.println(cartEmptyMessage);
    }
}
