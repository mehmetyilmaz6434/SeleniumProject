package tests_pratik;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_GetPageSource_R {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //test if Amazon contains "Registry" on the homepage
        driver.get("https://www.amazon.com/");
        String homePage=driver.getPageSource();
        String expectedWord="Registry";

       if (homePage.contains(expectedWord)){
           System.out.println("PASS");
       }else {
           System.out.println("FAIL");
       }
    }


}
