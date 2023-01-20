package tests_pratik;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_BasicNavigation_R {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.walmart.com/");
        driver.get("https://www.amazon.com/");

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        driver.navigate().to("https://www.youtube.com/");
    }
}
