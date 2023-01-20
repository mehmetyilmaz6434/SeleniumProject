package tests;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day10_FileUploaded extends TestBase {
    @Test
    public void fileUploadedTest(){
        driver.get("https://the-internet.herokuapp.com/upload");
        //1.locate choose file
        WebElement chooseAFileElement=driver.findElement(By.id("file-upload"));


        //2.select a file from your comuter
        String userHome=System.getProperty("user.home");
        String pathOfFile=userHome+"\\Desktop\\File.txt.txt";

        //  Sending the path of the file that I want to upload.
       //   we can use send keys cause the input type file combination
        chooseAFileElement.sendKeys(pathOfFile);

        //3.then locate and click upload
        driver.findElement(By.id("file-submit")).click();

        //4.asserting
        boolean isequal=driver.findElement(By.xpath("//h3")).getText().equals("File Uploaded!");
        Assert.assertTrue(isequal);



    }
}
    /*
    How do you upload a file with selenium?
    -First selenium has limitation automation of files. But file upload can be done with selenium.
    We locate the chose file button and use send keys function to send the path of the file.
    Then we click upload button to upload the file.
    Path of the file should be dynamic - use System.getProperty("user.home");

                         LIMITATION
    Selenium has limitation automation DESKTOP APPS
    For example, we can not find path of files, or verify if file exists on out machines with selenum
    Instead we use java File libraries
     */






//    Class Name: FileUploadTest
//    Method Name: fileUploadTest
//    When user goes to https://the-internet.herokuapp.com/upload
//    When user selects an image from the desktop
//    And click on the upload button
//    Then verify the File Uploaded!  Message displayed


