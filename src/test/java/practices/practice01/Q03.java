package practices.practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Q03 {

        // ...Practice 3...
        // Create chrome driver by using @Before annotation and WebDriverManager
        // Go to url : http://www.uitestpractice.com/
      WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("http://www.uitestpractice.com/");

        }

        @Test
    public void test(){
            // Click on 'Form'
           driver.findElement(By.xpath("//a[.='Form']")).click();

            // Fill the First Name: John
            driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("John");

            // Fill the Last Name: Doe
            driver.findElement(By.id("lastname")).sendKeys("Doe");

            // Check the Marital Status: Married
            driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();

            // Check the Hobby: Reading
            driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();

            // Select the Country : Canada
            WebElement countryDropDown=driver.findElement(By.id("sel1"));
            Select select=new Select(countryDropDown);
            select.selectByVisibleText("Canada");

            // Fill the Date Of Birth: 1st February 2000
            driver.findElement(By.id("datepicker")).sendKeys("02/02/2000");

            // Fill the Phone Number: 12345
            driver.findElement(By.id("phonenumber")).sendKeys("12345");
            //Note firstly I use id attiribute name because id name is unique. otherwise I use xpath() method.

            // Fill the User Name: john_doe
            driver.findElement(By.id("username")).sendKeys("john_doe");

            // Fill the Eamil: john@doe.com
            driver.findElement(By.id("email")).sendKeys("john@doe.com");

            // Fill the About Yourself: My name is John Doe. I am a famous man. Because my name is used as a mock data everywhere.
            driver.findElement(By.id("comment")).sendKeys("My name is John Doe. I am a famous man. Because my name is used as a mock data everywhere.");

            // Fill the Password: John.123
            driver.findElement(By.id("pwd")).sendKeys("John.123");

            // Click on Submit Button
            driver.findElement(By.xpath("//button[@type='submit']")).click();

        }
             // Close the browser by using @After annotation
        @After
    public void tearDown(){
        driver.close();
        }



}
