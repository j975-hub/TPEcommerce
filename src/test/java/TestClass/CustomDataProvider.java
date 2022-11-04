package TestClass;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {

    @DataProvider(name = "sortedByProperties")
    public Object[][] getProperty(){
        Object[][] obj = {  {"Name"},{"Price"},{"Position"}  };
        return obj;
    }
}
