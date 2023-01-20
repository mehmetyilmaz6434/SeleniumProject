package tests;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class Day09_FileDownloadTest extends TestBase {
    /*
    Given
    Go to "https://testcenter.techproeducation.com/index.php?page=file-download"
When
    Download junit-4.13-beta-3.jar file
Then
    Verify if the file downloaded successfully
     */
    @Test
    public void downloadTest(){
        //Go to "https://testcenter.techproeducation.com/index.php?page=file-download"
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //Download junit-4.13-beta-3.jar file
        driver.findElement(By.partialLinkText("code.docx")).click();// entire the linkText in HTML=="b10 all test cases, code.docx"

        // Verify if the file downloaded successfully
        String userHome=System.getProperty("user.home");
        boolean isDownloaded= Files.exists(Path.of(userHome + "\\Downloads\\b10 all test cases, code.docx"));//Aynı dosyadan tekrar indirilirse  code (1).docx yazılır.
        assertTrue(isDownloaded);


    }
}
