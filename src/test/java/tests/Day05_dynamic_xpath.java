package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day05_dynamic_xpath {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @Test
    public void dynamicXpath(){
        //        THERE ARE DIFFERENT XPATH TO LOCATE A TEXT ELEMENT ON A PAGE
        //       1. XPATH = //*[.='TEXT OF THE ELEMENT']
        // Verify id "Username : Admin" is text is displayed on the page
        //[.='Username : Admin']  return the element whose text=Username : Admin
        WebElement usernametext=driver.findElement(By.xpath("//*[.='Username : Admin']"));
        Assert.assertTrue(usernametext.isDisplayed());//Username : Admin syafada gösteriliyormu diye assert yapıyor.

        //Verify id "Password : admin123"  text is displayed on the page
        WebElement passwordText=driver.findElement(By.xpath("//*[.='Password : admin123']"));
        Assert.assertTrue(passwordText.isDisplayed());//

        //       2. XPATH = //[(text()='TEXT OF THE ELEMENT')]   ==>//*[(text()='Username : Admin')]

        WebElement usernameText1=driver.findElement(By.xpath("//*[(text()='Username : Admin')]"));
        Assert.assertTrue(usernameText1.isDisplayed());

        //        Verify if "Password" text is displayed on the page
        //        3. XPATH = //*[contains(text(),'PARTIAL OR FULL TEXT OF THE ELEMENT');

        WebElement passwordText1= driver.findElement(By.xpath("//*[contains(text(),'Passwo')]"));
        Assert.assertTrue(passwordText1.isDisplayed());//contains partialLinkText gibi düşünülebilir.

    }

}
