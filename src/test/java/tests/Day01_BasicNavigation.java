package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_BasicNavigation {
    public static void main(String[] args) {
        //Step 1:Set Up
       // System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver.exe");

        //step 2:Create
        WebDriver driver=new ChromeDriver();
        //Step 3:Write test scripts


        //Maximize the window
        driver.manage().window().maximize();//===>we can open the page full screen

        //Open google home page https://www.walmart.com/
        driver.get("https://www.walmart.com/");

        //On the same class, Navigate to amazon home page https://www.amazon.com/
        driver.get("https://www.amazon.com/");//    firstly it opens walmart page then amazon page.
        driver.navigate().to("https://www.amazon.com/");

        //Navigate back to google
        driver.navigate().back();//      it opens walmart==>amazon==>walmart

        // Navigate forward to amazon
        driver.navigate().forward();//   it opens walmart==>amazon==>walmart==>amazon

        //Refresh the page
        driver.navigate().refresh();

        //Close/Quit the browser
        driver.close();// or "driver.quit();"
        //Note: if we use "close()" the all wimdows will closed.otherwise with quit() only the last window will closed.




    }
}
