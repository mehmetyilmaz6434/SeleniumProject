package tests;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day14_TimeoutExceptions extends TestBase {
    @Test
    public void timeoutExceptionsTest(){
        driver.get("https://techproeducation.com/");

        //org.openqa.selenium.TimeoutException
        waitForVisibility(By.xpath("//123"),3);//If it can not find the element in 3 secs, it will throw exception


    }
}
