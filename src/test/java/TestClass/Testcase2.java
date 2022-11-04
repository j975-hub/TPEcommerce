package TestClass;

import WebUtils.InstanceSetup;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

//@Listeners(CustomListener.class)
public class Testcase2 {
    InstanceSetup instanceSetup;

    public void openBrowser() throws IOException {
        instanceSetup = new InstanceSetup();
    }
    @Test(groups = "Regression")
    public void verificationBetweenListAndDetailed() throws InterruptedException {
    try{
        openBrowser();
        instanceSetup.pageobjectmanager.goToHomepage().clickOnMobileMenu();
        }catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
        try{
           String listPagePrice = instanceSetup.pageobjectmanager.goToHomepage().getSonyXperiaMobileCostInListPage();
           instanceSetup.pageobjectmanager.goToHomepage().clickOnSonyXperiaMobileLink();
           String detailsPagePrice = instanceSetup.pageobjectmanager.goToMobilepage().getSonyXperiaMobileCostInDetailsPage();
           Assert.assertEquals(listPagePrice,detailsPagePrice);
        }catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }finally {
            Thread.sleep(3000);
            instanceSetup.driver.quit();
        }
    }

}
