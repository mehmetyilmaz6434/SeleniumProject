package tests;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Day13_JSExecuter extends TestBase {
    /*
    Given
        Go to https://techproeducation.com/"
    When
        Scroll into "WE OFFER"
    And
        Scroll into "LMS LOGIN"
    And
        Scroll into "WHY US"
    And
        Scroll back up to "Enroll Free"
    And
        Scroll all the way down
    And
        Scroll all the way up
    Then
        Take a screenshot of each step
     */
    @Test
    public void scroolIntoWiewTest() throws IOException {

//      Go to https://techproeducation.com/"
        driver.get("https://techproeducation.com/");
       //Thread.sleep(3000);
        waitFor(3);
        takeScreenshotOfPage();

//      Scroll into "WE OFFER"
        WebElement weOffer=driver.findElement(By.xpath("//*[.='we offer']"));
        //Create JS Executer object
        JavascriptExecutor js=(JavascriptExecutor)driver;//==>type casting is used here.
        js.executeScript("arguments[0].scrollIntoView(true)",weOffer);//yeşil kısım JS code.
        takeScreenshotOfPage();

//      Scroll into "LMS LOGIN"
        waitFor(3);
        js.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.linkText("LMS LOGIN")));
        takeScreenshotOfPage();

//      Scroll into "WHY US"
        waitFor(3);
        //this is reusable method in testbase class
        js.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.xpath("//h3[.='WHY US?']")));
        takeScreenshotOfPage();

//      Scroll back up to "Enroll Free"
        waitFor(3);
        scrollIntoViewByJs(driver.findElement(By.xpath("//*[.=' Enroll Free ']")));//Test base de method olarak üretildi.
        takeScreenshotOfPage();

//      Scroll all the way down
        waitFor(2);
        scrollAllTheWayDownByJS();
        takeScreenshotOfPage();

//      Scroll all the way up
        waitFor(2);
        scrollAllTheWayUpByJS();
        takeScreenshotOfPage();

//      Take a screenshot of each step



    }
    @Test
   public void clickByJSTest(){
        driver.get("https://techproeducation.com/");
        clickByJS(driver.findElement(By.linkText("LMS LOGIN")));
    }
    @Test
    public void typeInTheInputTest(){
        driver.get("https://techproeducation.com/");
        setValueByJS(driver.findElement(By.xpath("//input[@type='search']")), "QA");
        //sayfadaki arama çubuğuna "QA" yazdırıyor.

    }
    @Test
    public void getValueOfInputTest(){

        driver.get("https://www.priceline.com/");
        getValueByJS("hotelDates");//id kullanılarak locate yapılıyor.

    }
    @Test
    public void colorByJSTest(){
        driver.get("https://www.priceline.com/");
        changeBackgroundColorByJS(driver.findElement(By.xpath("//button[@data-testid='HOTELS_SUBMIT_BUTTON']")),"yellow");
        addBorderWithJS(driver.findElement(By.xpath("//button[@data-testid='HOTELS_SUBMIT_BUTTON']")),"5px solid green");
    }


}
