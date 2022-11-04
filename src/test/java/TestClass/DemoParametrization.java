package TestClass;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoParametrization {

    @Parameters({"browser","url"})
    @Test
    public void openTest(String browserName , String urlName){

    System.out.println("Browser : " + browserName);
    System.out.println("URL : " + urlName);

    }
}
