package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Day03_Locators {
    /*
        User goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        Locate the elements of Username textbox, Password textbox, and Login button
        Enter below username and password then click on login button
                Username :  Admin
                Password :  admin123
        Verify the login is successful
        Sign out from the page
        */
  WebDriver driver;
   @Before
   public void setUp(){
       //User goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();//use the driver again and again. artık driver ChromeDriver() constructor nın bütün methodlarına sahip.
       driver.manage().window().maximize();
       driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

   }
    @Test
    public void loginTest() throws InterruptedException {

       Thread.sleep(10000);

        //Locate the elements of Username textbox, Password textbox, and Login button
        WebElement userNameTextBox=driver.findElement(By.xpath("//input[@name='username']"));//inspect==>ctrl-F==>ctrl-C==>ctrl-V as xpath().

        //Username==>inspect==>come over higlighted part==>copy==>copy xpath==> "//input[@name='username']"
        // (driver'deki  path yolu ile veya name ile   elemnti bul!)
        WebElement password=driver.findElement(By.name("password"));
        Thread.sleep(6000);
        WebElement loginButton =driver.findElement(By.xpath("//button[@type='submit']"));//done)


       //Enter below username and password then click on login button
        //                Username :  Admin
        //                Password :  admin123

        userNameTextBox.sendKeys("Admin");//giriş sayfasında yer alıyor. Bundan dolayı WebElement sınıfındaki metodu kullanmıyoruz.
        password.sendKeys("admin123");
        loginButton.click();

        //Assert the login is succesful

        //"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"==>current URL  login yaptıktan sonraki url

        boolean actualValue=driver.getCurrentUrl().contains("dashboard");//son girilen url yani login yaptıktan sonraki link.
        assertTrue(actualValue);

        //Note: We dont need to use containers for web elements. We can use method chain for actions.



   }



   @After
    public void tearDown(){
       driver.quit();
   }

}
