package tests;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Day07_WindowHandle extends TestBase {
    @Test
    public void windowHandleTest() throws InterruptedException {

        //        Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");

        //        Then user verifies the text : “Opening a new window”
        String window1Test= driver.findElement(By.xpath("//h3")).getText();
        assertEquals("Opening a new window",window1Test);

        //        Then user verifies the title of the page is “The Internet”
        assertEquals("The Internet",driver.getTitle());

        //        GETTING THE WINDOW 1 HANDLE(UNIQUE PAGE ID)
        Thread.sleep(2000);
        String window1Handle= driver.getWindowHandle();//Returns the current window id.
        System.out.println(window1Handle);

        //        When user clicks on the “Click Here” button
        Thread.sleep(2000);
        driver.findElement(By.linkText("Click Here")).click();


        //        Then user verifies the new window title is “New Window”
        Thread.sleep(2000);
        assertEquals("The Internet",driver.getTitle());

        //        WE DO TESTING IN A NEW WINDOW, SO WE MUST SWITCH TO THAT WINDOW
        //        AS OF NOW 2 WINDOWS OPEN. USE getWindowHandles() TO GET BOTH IDs
        Set<String> allWindowHandles=driver.getWindowHandles();
        System.out.println(allWindowHandles);
        for (String eachHandle: allWindowHandles){//looping through the windows
            if (!eachHandle.equals(window1Handle)){////if we are not in windows 1 (means windows 2)
                driver.switchTo().window(eachHandle);//then switch the window 2
            }
        }

        //        Then user verifies the text:  “New Window”
        //        When user goes back to the previous window and then verifies the title : “The Internet”

        //        AT THIS POINT DRIVER IS SWITCHED TO WINDOWS 2
        //        Then user verifies the text:  “New Window”
        Thread.sleep(2000);
        String window2Handle = driver.findElement(By.xpath("//h3")).getText();
        assertEquals("The Internet",window2Handle);
        //        When user goes back to the previous window and then verifies the title : “The Internet”
        Thread.sleep(2000);
        driver.switchTo().window(window1Handle);

        //        Then user verifies the title of the page is “The Internet”
        assertEquals("The Internet",driver.getTitle());

        //        Switch back to window 2
        Thread.sleep(2000);
        driver.switchTo().window(window2Handle);
        Thread.sleep(5000);
//        Switch back to window 1
        driver.switchTo().window(window1Handle);
        Thread.sleep(5000);
        //        Switch back to window 2
        driver.switchTo().window(window2Handle);
        Thread.sleep(5000);
//        Switch back to window 1
        driver.switchTo().window(window1Handle);
















    }

}
