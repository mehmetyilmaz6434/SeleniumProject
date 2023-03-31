package tests;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Day08_Actions02 extends TestBase {
    /*
        Given
                Go to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
        When
                Hover over "Hover Div"
        And
                Click on “Can you click me?” link.
        Then
                Verify the text "Action Complete".
        */
    @Test
    public void hoverOverTest() throws InterruptedException {

        //Go to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");

       // Hover over "Hover Div"
        Actions actions=new Actions(driver);
        WebElement hoverDiv=driver.findElement(By.id("hoverdivpara"));//mouse'yi sürükleyeceğimiz alan tespit edildi
        Thread.sleep(2000);
        actions.moveToElement(hoverDiv).perform();//mouse'yi üzerine getirme işlemi yapıldı.

        //Click on “Can you click me?” link.
        Thread.sleep(2000);
        driver.findElement(By.id("hoverlink")).click();//üzerine geldiğimiz alanda click yapılacak link çıktı. one locate yaptık,
                                                       // ve tıkladık.

        //Verify the text "Action Complete".
      String actionCompleteRest= driver.findElement(By.xpath("//h1")).getText();
        assertEquals("Action Complete",actionCompleteRest);



    }
}
