package Practice02;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class Q03 extends TestBase {
      /*
    Given
        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
    When
        Click "CLICK ME" of JavaScript Alert
    And
        Get the alert text
    Then
        Verify that message is "I am an alert box!"
    When
        Accept alert
     */
    @Test
    public void test(){
        //Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

        //lick "CLICK ME" of JavaScript Alert
        driver.findElement(By.xpath("(//p)[1]")).click();

        //Verify that message is "I am an alert box!"
        String alertTest=driver.switchTo().alert().getText();
        assertEquals(alertTest,"I am an alert box!");

        //Accept alert
        driver.switchTo().alert().accept();

    }
}
