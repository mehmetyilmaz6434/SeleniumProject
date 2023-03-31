package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_URLVerification {
    public static void main(String[] args) {

        //System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techproeducation.com");

        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="https://www.amazon.com";

        if (actualUrl.equals(expectedUrl)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("expectedUrl is "+expectedUrl);
            System.out.println("But actualUrl is "+actualUrl);
        }
        driver.quit();
    }
}
