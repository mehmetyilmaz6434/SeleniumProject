package tests_pratik;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_TitleVerification_R {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        String actualTitle=driver.getTitle();
        String expecteTitle="Techpro Education | Online It Courses & Bootcamps";

        if (actualTitle.equals(expecteTitle)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }
}
