package tests;

import Utilities.TestBase;
import org.junit.Test;

public class Day07_TestBaseDemo extends TestBase {
    @Test
    public void test1(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=radio-buttons");
        System.out.println(driver.getTitle());
    }
    @Test
    public void test2(){
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getTitle());
    }


}

