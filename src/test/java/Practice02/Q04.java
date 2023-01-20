package Practice02;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertTrue;

public class Q04 extends TestBase {
       /*
   Given
        Go to https://www.gmibank.com/
   When
        Hover over "Premium" Deposit Package
   And
        Click on "Book Now"
   Then
        Verify url contains "services"
    */
    @Test
    public void test(){
        //Go to https://www.gmibank.com/
        driver.get("https://www.gmibank.com/");

        //Hover over "Premium" Deposit Package
        WebElement premium=driver.findElement(By.xpath("(//h4[@class='pricing-title'])[2]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(premium);

        //Click on "Book Now"
        driver.findElement(By.linkText("Book Now")).click();
       //driver.findElement(By.xpath("(//a[@class='btn btn-blue initiate-scripts'])[3]")).click();==>We can type this instead of upper code line.


        //Verify url contains "services"
       String url=driver.getCurrentUrl();
       assertTrue(url.contains("services"));




    }
}
