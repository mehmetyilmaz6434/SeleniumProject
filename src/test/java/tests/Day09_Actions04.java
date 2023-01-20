package tests;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Day09_Actions04 extends TestBase {
    /*
        Given
                Go to "https://jqueryui.com/droppable/"
        When
                Drag the element "Drag me to my target" to "Drop here" element and drop it.
        */
    @Test
    public void dragAnddropTest() throws InterruptedException {
        //Go to "https://jqueryui.com/droppable/"
        driver.get("https://jqueryui.com/droppable/");

        //Since the elements are in an iframe we need to switch to iFrame first
        driver.switchTo().frame(0);//because trhere is only one iFrame on the page.

        //Drag the element "Drag me to my target" to "Drop here" element and drop it.
        //1.Create Actions object
        Actions action=new Actions(driver);

        //2.Locate source and target web elements
        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droppable"));

        //3.Use dragAndDrop() method with web elements.
       Thread.sleep(2000);
        action.dragAndDrop(source,target).perform();

        /*
       If you can not find element:
    Look for:
        1.check the locator
        2.check wait or synchronization issue
        3.iframe

         */







    }
    @Test
    public void clickAndHoldTest() throws InterruptedException {
        //Go to "https://jqueryui.com/droppable/"
        driver.get("https://jqueryui.com/droppable/");

        //Since the elements are in an iframe we need to switch to iFrame first
        driver.switchTo().frame(0);//because rhere is only one iFrame on the page.

        //Drag the element "Drag me to my target" to "Drop here" element and drop it.
        //1.Create Actions object
        Actions action=new Actions(driver);

        //2.Locate source and target web elements
        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droppable"));

        //3.Use clickAndHold() method with web elements.
        Thread.sleep(2000);
        action.clickAndHold(source).moveToElement(target).build().perform();


    }
    @Test
    public void dragAndDropByTest() throws InterruptedException {
        //Go to "https://jqueryui.com/droppable/"
        driver.get("https://jqueryui.com/droppable/");

        //Since the elements are in an iframe we need to switch to iFrame first
        driver.switchTo().frame(0);//because rhere is only one iFrame on the page.

        //Drag the element "Drag me to my target" to "Drop here" element and drop it.
        //1.Create Actions object
        Actions action=new Actions(driver);

        //2.Locate source and target web elements
        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droppable"));

        //3.Use clickAndHold() method with web elements.
        Thread.sleep(2000);
        action.dragAndDropBy(source,163,28).perform();



    }
    @Test
    public void moveByOffsetTest() throws InterruptedException {
        //Go to "https://jqueryui.com/droppable/"
        driver.get("https://jqueryui.com/droppable/");

        //Since the elements are in an iframe we need to switch to iFrame first
        driver.switchTo().frame(0);//because there is only one iFrame on the page.

        //Drag the element "Drag me to my target" to "Drop here" element and drop it.
        //1.Create Actions object
        Actions action=new Actions(driver);

        //2.Locate source and target web elements
        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droppable"));

        //3.Use moveByOffset() method with web elements.
        Thread.sleep(2000);
        action.clickAndHold(source).moveByOffset(160,40).perform();



    }

}
