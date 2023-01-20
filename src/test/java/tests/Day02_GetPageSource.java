package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_GetPageSource {
    public static void main(String[] args) {
        //// System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //test if Amazon contains "Registry" on the homepage
        driver.get("https://www.amazon.com/");
        String pageSource=driver.getPageSource();
        String expectedWord="Registry";


        if (pageSource.contains(expectedWord)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("pageSource : "+pageSource);
            System.out.println("Expected word : "+ expectedWord);
        }
        driver.quit();

    }


}
