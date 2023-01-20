package tests;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class Day11_ScreenshotOfSpecificElements extends TestBase {
    @Test
    public void screenshotTest() throws IOException {
        driver.get("https://www.techproeducation.com/");

        WebElement techProEdLogo=driver.findElement(By.xpath("//div[@data-id='898ce2e']"));
        //verifying thr logo
        Assert.assertTrue(techProEdLogo.isDisplayed());
        //Taking the screenshot as proff
        File image=techProEdLogo.getScreenshotAs(OutputType.FILE);
        //Calling the screenshot using reusable method
        takeScreenshotOfPageTheElement(techProEdLogo);

        //Taking screenshot of social media icons
        WebElement socials=driver.findElement(By.xpath("//div[@data-id='d7545f2']"));
        takeScreenshotOfPageTheElement(socials);
    }
}
