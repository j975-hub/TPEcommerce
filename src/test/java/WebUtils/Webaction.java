package WebUtils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


 public class Webaction {
   private JavascriptExecutor js;
   private WebDriver driver;
   private WebDriverWait wait;
   private   Select select;


     public Webaction(WebDriver driver) {
         this.driver = driver;
     }

      protected void drawBorder(WebElement element){
        js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='3px solid red'",element);
    }

        protected void waitAndClick(WebElement element){
        drawBorder(element);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
        if(element.isDisplayed()==true){
            element.click();
        } else {
            Assert.assertNotEquals(element," is not displayed ");
        }
    }
        protected String waitAndGetValue(WebElement element){
            drawBorder(element);
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(element));
            Assert.assertTrue(element.isDisplayed());
            if(element.isDisplayed()==true){
               return element.getText().trim();
            } else {
                Assert.assertNotEquals(element," is not displayed ");
            }
            return null;
        }
     protected void waitAndSendKeys(WebElement element,String text){
         drawBorder(element);
         wait = new WebDriverWait(driver, Duration.ofSeconds(30));
         wait.until(ExpectedConditions.visibilityOf(element));
         if(element.isDisplayed()==true){
             element.clear();
             element.sendKeys(text);
         } else {
             Assert.assertNotEquals(element," is not displayed ");
         }
     }
        protected void selectClassElement(WebElement element,String text){
            drawBorder(element);
            select = new Select(element);
            select.selectByVisibleText(text);
        }
        protected void customizeScreenShotCapture(String fileName,WebElement element) throws IOException {
            drawBorder(element);
           File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(".\\ScreenShotImageStore\\CustomizeScreenShot\\"+fileName+".png"));
        }
        protected void customizeScreenShotCapture(String fileName) throws IOException {
         File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(src, new File(".\\ScreenShotImageStore\\CustomizeScreenShot\\"+fileName+".png"));
     }

         public static void failureTestCaseScreenShotCapture(String fileName,WebDriver driver) throws IOException {
          File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          FileUtils.copyFile(src, new File(".\\ScreenShotImageStore\\TestCaseFailureScreenshotImage\\"+fileName+".png"));
     }
        protected void handlingWindows(){
            for(String window:driver.getWindowHandles()){
                driver.switchTo().window(window);
            }
        }
        public void clickElementByJS(WebElement element){
         JavascriptExecutor js = ((JavascriptExecutor) driver);
         js.executeScript("arguments[0].click();",element);
     }
}
