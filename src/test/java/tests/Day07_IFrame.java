package tests;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day07_IFrame extends TestBase {
    @Test
    public void iframeTest(){

//        Create a class: IFrame
//        Create a method: iframeTest
//        Go to https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");

        //       Verify the Bolded text contains “Editor”
        //Note: header is not in the iframe so no need to switch.
        String header= driver.findElement(By.xpath("//h3")).getText();//the header is in "<h3>"
        Assert.assertTrue(header.contains("Editor"));


        // NOTE: textbox is in the iframe so we have to switch to the iframe.
        driver.switchTo().frame(0);                                                               //1)Index
        driver.switchTo().frame("mce_0_ifr");                                                  //2)By id name
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));//3)By WebElement

        //        Locate the text box
        WebElement box= driver.findElement(By.xpath("//p"));

        //        Delete the text in the text box
        box.clear();//clear() is used to delete the text is the elements

        //        Type “This text box is inside the iframe”
        box.sendKeys("This text box is inside the iframe");
        //        SO FAR DRIVER IS IN THE IFRAME BUT Elemental Selenium text IS OUTSIDE OF THE FRAME
        //        GETTING OUT OF THE FRAME
        driver.switchTo().parentFrame();//"Elemental Selenium" u görebilmek için bo kod ile frame dışına çıkıyoruz.

        //        ALTERNATIVELY WE CAN USE defaultContent()
        //        Verify the text Elemental Selenium text is displayed on the page
        Assert.assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());

    }
    /*
    What might be the reason for your test case to fail?
There may be wait problem. The page may be very slow. Internet maybe not fast enough.
Put some more wait. We can use explicit wait in selenium(we will learn later)
Locator might be incorrect.
Double check locator and fix if needed
Data issue. Typo in our expected values.
If there is any documentation issue, we can talk to BA to fix the document and then we can use correct expected values
Maybe there is an iframe on the page
We first need to switch to the frame
Maybe there is an alert on the page
We first need to handle the alert by accepting or dismissing
It may be a real bug that is caused by the latest codes.
We discuss the issue with the team then raise a bug ticket if needed
     */
}
