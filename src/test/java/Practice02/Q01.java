package Practice02;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Q01 extends TestBase {
    /*
    Given
         Go to url : https://phptravels.com/demo/
    When
         Fill the form
    And
         Click on 'SUBMIT'
    Then
         Assert that the form has been sent
     */
    @Test
    public void test() throws InterruptedException {
        //Go to url : https://phptravels.com/demo/
        driver.get("https://phptravels.com/demo/");

        //Fill the form
        driver.findElement(By.name("first_name")).sendKeys("Joe");
        driver.findElement(By.name("last_name")).sendKeys("Doe");
        driver.findElement(By.name("business_name")).sendKeys("QA Engineer");
        driver.findElement(By.name("email")).sendKeys("joe@doe.com");

        //Handle the addition operation then the result to resultinput
        int numb1= Integer.parseInt(driver.findElement(By.id("numb1")).getText());//wrapper class is used here.  String==>Integer
        int numb2= Integer.parseInt(driver.findElement(By.id("numb2")).getText());
        String result= numb2+numb1+"";//aşağıdaki satırda sendkeys içine string karakter yazılmalı bu yüzden String edönüştürüldü.
        //String.valueOf(result);==> bu şekilde de string e çevrilebilir.
        driver.findElement(By.id("number")).sendKeys(result);

        //Click on 'SUBMIT'
        driver.findElement(By.id("demo")).click();

        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        //Assert that the form has been sent
        WebElement thankYou = driver.findElement(By.xpath("//strong[.=' Thank you!']"));
        boolean isThankYou = thankYou.isDisplayed();
        assertTrue(isThankYou);

        //or
        String textOfElement = thankYou.getText();
        assertTrue(textOfElement.contains("Thank you"));


    }
    //sadece tagname ve attiribute valu olduğu için  nokta kullandık.
}
