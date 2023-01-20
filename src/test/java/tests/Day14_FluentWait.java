package tests;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Day14_FluentWait extends TestBase {
      /*
Given
    Go to https://the-internet.herokuapp.com/dynamic_loading/1
When
    User clicks on the "Start" button
Then
    Assert the "Hello World!" Shows up on the screen
 */


    //we will handle wait issue wit fluentWait.
    @Test
    public void fluentwaitTest(){
//        Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

//        User clicks on the "Start" button
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

//        Assert the "Hello World!" Shows up on the screen
        //Fluent Wait
        //1.Step: Create wait object
        Wait <WebDriver> wait=new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(15)).//Total Wait
                pollingEvery(Duration.ofSeconds(2)).//Checking Period of Web Element==>Ths will check the web element in each 2 secs.
                withMessage("Ignoring No such ElementException").//Optionals:Giving Custom Message
                ignoring(NoSuchElementException.class);//Optionals:Ignoring Exception
        //2.Step: Use wait object,apply wait.
        WebElement helloWorld=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[.='Hello World!']")));
        assertEquals("Hello World!",helloWorld.getText());
    }
    @Test
    public void fluentWaitReusable(){//yukarıdaki test in method kullanılmış hali.
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
        //fluentWait() method is the reusable method of fluent wait.
        String helloWorldText=fluentWait("//h4[.='Hello World!']",10,2).getText();
        assertEquals("Hello World!",helloWorldText);
    }
}
