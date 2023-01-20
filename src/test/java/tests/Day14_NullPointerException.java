package tests;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Day14_NullPointerException  {
    WebDriver driver;//null
    Integer number;//null
    String str;//null
    @Test
    public void nullPointerExceptionTest(){
        driver.get("https://techproeducation.com/");
    }

    @Test
    public void nullPointerExceptionTest2(){
        System.out.println(number+1);//number is not assigned. so it is null
    }
    @Test
    public void nullPointerExceptionTest3(){
        str.substring(0);
    }
}
