package practices.practice01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q01 {
    //...Practice 1...
    // Set Driver Path
    // Create chrome driver object
    // Maximize the window
    // Open google home page https://www.google.com/
    // Navigate to techproeducation home page https://techproeducation.com/
    // Navigate back to google
    // Navigate forward to techproeducation
    // Refresh the page
    // Close/Quit the browser
    // And last step : print "ALL OK" on console

    public static void main(String[] args) throws InterruptedException {
        //...Practice 1...
        // Set Driver Path
        //System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");

        // Create chrome driver object
        WebDriver driver=new ChromeDriver();//WebDriver is parent class, ChromeDriver() is chil class.

        // Maximize the window
        driver.manage().window().maximize();

        // Open google home page https://www.google.com/
        driver.get("https://www.google.com/");

        // Navigate to techproeducation home page https://techproeducation.com/
        driver.navigate().to("https://techproeducation.com/");

        // Navigate back to google
        Thread.sleep(100);
        driver.navigate().back();

        // Navigate forward to techproeducation
        driver.navigate().forward();

        // Refresh the page
        driver.navigate().refresh();

        // Close/Quit the browser
        driver.quit();
        // And last step : print "ALL OK" on console
        System.out.println("ALL OK");
    }
}
