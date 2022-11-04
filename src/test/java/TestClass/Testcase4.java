package TestClass;

import WebUtils.InstanceSetup;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;


public class Testcase4 {
    InstanceSetup instanceSetup;


    public void openBrowser() throws IOException {
        instanceSetup = new InstanceSetup();

    }

    @Test(groups = {"Sanity,Regression"})
    public void compareTwoProducts() throws IOException, InterruptedException {
        try{
            openBrowser();
            instanceSetup.pageobjectmanager.goToHomepage().clickOnMobileMenu();
            instanceSetup.pageobjectmanager.goToMobilepage().clickOnSonyXperiaAddToCompare();
            instanceSetup.pageobjectmanager.goToMobilepage().clickOnIphoneAddToCompare();
            instanceSetup.pageobjectmanager.goToMobilepage().clickOnCompareButton();
            clickOnCompareButton();
        }catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }finally {
            Thread.sleep(3000);
            instanceSetup.driver.quit();
        }
    }

    public void clickOnCompareButton() throws IOException {
        instanceSetup.driver.findElement(By.xpath("//span[text()='Close Window']")).click();
    }
}