package tests;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Day08_Authentication extends TestBase {
    /*
        username : admin
        pass     : admin
        url      : the-internet.herokuapp.com/basic_auth
        SPECIAL URL FOR AUTHENTICATION:
        GO LINK  : https://username:pass@url
         */
    @Test
    public void authenticationTest(){
       //authenytication
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //Assertion
        assertTrue(driver.findElement(By.xpath("//h3")).getText().contains("Basic Auth"));

    }

}
