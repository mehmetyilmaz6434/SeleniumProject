import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Firstclass {

    public static void main(String[] args) {

        //1)Setting the path for chromedriver
        //System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");

        //2)Create chorome driver
        WebDriver driver =new ChromeDriver();

        //3)Write your test cases
        driver.get("https://www.techproeducation.com");


    }
}
