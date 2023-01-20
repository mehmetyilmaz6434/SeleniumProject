package tests;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day14_NoSuchElementExceptions extends TestBase {
    @Test
    public void noSuchElementExceptionsTest(){
        driver.get("https://techproeducation.com/");

        //wrong locator
        driver.findElement(By.id("wrong-id")).click();//org.openqa.selenium.NoSuchElementException

    }
}
