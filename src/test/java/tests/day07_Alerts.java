package tests;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class day07_Alerts extends TestBase {
    @Test
    public void acceptAlert() throws InterruptedException {

      //  acceptAlert() => click on the first alert,
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        Thread.sleep(2000);
        //               verify the text “I am a JS Alert” ,
       String alertText= driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS Alert",alertText);

     //        click OK ,
        driver.switchTo().alert().accept();//with "accept()" method we can click on the alert.
        Thread.sleep(2000);

        //        and Verify “You successfully clicked an alert”
        String actualResult=driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You successfully clicked an alert",actualResult);
        Thread.sleep(2000);

    }
    @Test
    public void dissmissAlert(){
//        dismissAlert()=> click on the second alert,
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
//                verify text "I am a JS Confirm”
        String alertText=driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS Confirm",alertText);

//        click cancel,
        driver.switchTo().alert().dismiss();

        //        and Verify “You clicked: Cancel”
        String actualResult=driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You clicked: Cancel",actualResult);

    }
    @Test
    public void sendKeysTest() throws InterruptedException {
        Thread.sleep(2000);

//    sendKeysAlert()=> click on the third alert,
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(2000);

//    verify text “I am a JS prompt”,
       String alertSendKeysTest=driver.switchTo().alert().getText();
       Assert.assertEquals("I am a JS prompt",alertSendKeysTest);

 //    type “Hello World”,
        driver.switchTo().alert().sendKeys("Hello World");

        //    click OK,
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        //    and Verify “You entered: Hello World”
        String actualResult=driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You entered: Hello World",actualResult);
        Thread.sleep(2000);
    }

    /*

                            What is an alert?
                        Alerts are a pop up that is generated by javascript.
                        When there is an alerts, we must handle the alerts.
                        Otherwise, we cannot continue to the test execution

                           How do you handle alert?
                        First we cannot inspect js alerts. We should first switch
                        to the alert and use accept() to click ok, dismiss() to
                        click cancel, sendKeys() to type, getText() to get the
                        text from the alert     */



















}
