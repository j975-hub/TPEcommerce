package TestClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoParametrization1 {


    @Test(dataProvider = "openBrowser")
    public void openTest(String browserName , String urlName){

    System.out.println("Browser : " + browserName);
    System.out.println("URL : " + urlName);

    }

    @DataProvider(name = "openBrowser")
    public Object[][] getData(){

      Object[][] obj = {
                            { "chrome","http://live.techpanda.org" },
                            { "firefox","https://www.selenium.dev/" }
                       } ;
      return obj;
            }
}
