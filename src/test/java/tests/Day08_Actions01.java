package tests;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;

public class Day08_Actions01 extends TestBase {
    /*
        Given
                Go to "https://the-internet.herokuapp.com/context_menu"
        When
                Right click on the box
        Then
                Verify the alert message is “You selected a context menu”
        And
                Accept the alert
        */
    @Test
    public void rightClickTest() throws InterruptedException {
        //Go to "https://the-internet.herokuapp.com/context_menu"
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Right-click on the box
        //1st Step: Create "actions" object
       Actions actions= new Actions(driver);

        //2nd Step: Locate the web element you want to right-click
       WebElement box= driver.findElement(By.id("hot-spot"));

        //3rd Step: Use actions object with proper method.
        actions.contextClick(box).perform();       //contextClick() method ensures clicking right button of the mouse.

        //Verify the alert message is “You selected a context menu”
        Thread.sleep(2000);
        String alertTest= driver.switchTo().alert().getText();//getText() method returns web element as a string.

       assertEquals("You selected a context menu",alertTest);

       //Accept the alert
       Thread.sleep(2000);
        driver.switchTo().alert().accept();



    }
}
