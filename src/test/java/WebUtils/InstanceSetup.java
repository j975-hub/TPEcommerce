package WebUtils;

import TestBase.BaseClass;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InstanceSetup {

   public InstanceSetup instanceSetup;
   public BaseClass baseClass;
   public WebDriver driver;
   public Pageobjectmanager pageobjectmanager;

    public InstanceSetup() throws IOException {
         baseClass = new BaseClass();
         driver =  baseClass.initializeDriver();
         pageobjectmanager = new Pageobjectmanager(driver);
    }

    public JsonPath getJsonResponse(String fileName) throws IOException {
        String pathName =  new String( Files.readAllBytes(Paths.get(".\\TestData\\JsonFile\\"+fileName+".json")) );
        JsonPath jsonPath = new JsonPath(pathName);
        return jsonPath;
    }

}
