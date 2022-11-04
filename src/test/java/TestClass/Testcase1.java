package TestClass;

import WebUtils.InstanceSetup;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;


public class Testcase1 {

    InstanceSetup instanceSetup;


    public void openBrowser() throws IOException {
         instanceSetup = new InstanceSetup();
    }
    @Test(groups={"Sanity"} ,dataProvider = "sortedByProperties" , dataProviderClass = CustomDataProvider.class)
    public void sortingMobileBy(String property) throws IOException, InterruptedException {
        try {
            openBrowser();
            String getTitle = instanceSetup.driver.getTitle();
            System.out.println(getTitle);
            Assert.assertEquals(getTitle,"Home page");
        }catch (Exception e){
            System.out.println("Exception:" + e.getMessage());
        }
        try {
             instanceSetup.pageobjectmanager.goToHomepage().clickOnMobileMenu();
             String getTitle = instanceSetup.driver.getTitle();
             System.out.println(getTitle);
             Assert.assertEquals(getTitle,"Mobile");
        }catch (Exception e){
            System.out.println("Exception:" + e.getMessage());
        }
        try {
                instanceSetup.pageobjectmanager.goToHomepage().sortingBy(property);
        }catch (Exception e){
            System.out.println("Exception:" + e.getMessage());
        }finally {
            Thread.sleep(3000);
            instanceSetup.driver.quit();
        }

    }


}
