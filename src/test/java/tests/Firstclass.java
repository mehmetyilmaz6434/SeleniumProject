package tests;

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

    public static class Day_03URLVerification {
        public static void main(String[] args) {

            WebDriver driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.techproeducation.com");


            //Verify if google homepage url is "https://techproeducation.com/".,

            String actualUrl=driver.getCurrentUrl();
            String expectedUrl="https://techproeducation.com/";
            if (actualUrl.equals(expectedUrl)){
                System.out.println("PASS");
            }else {
                System.out.println("FAIL");
                System.out.println("Actual Url :"+actualUrl);
                System.out.println("Expected Url :"+expectedUrl);
            }
            driver.quit();

             /*
            ===========Approach for Automation========

        1) I read the acceptance criteria very very carefully
        2) I then create my test case
        3) Then I do "Manual Testing" FIRST helps us to undrestand THE APPLICATION
        4) If all above good, I start complete my automation script
        4) If I find any bug/defect, then I talk to dev. Dev fixes the issue, then I reset.If all is good then start my AUTOMATION
        5) when Automation is complete, I prepare the report for the user story. In fact, My Automation script generate html
        reports for us, I upload those reports to the JIRA.
        for my MANUAL test cases, I manually take screenshots and prepare reports and attach them to the JIRA.
    -------------------------------------------------
        WHAT DO WE DO WHEN OUR TEST CASE PASS ?
        - Prepare report and upload to JIRA
    --------------------------------------------------
        WHAT DO YOU DO WHEN YOUR TEST CASE FAILS?
        -Retest to make sure from the failure.It can be data issue, typo, documentation issue or is can be a real bug.
        -If that is a bug, then talk to the dev and let them fix the bug.
        -After the fix, we retest. when test cases passes we upload to JIRA
    ------------------------------------------------
        WHAT DO YOU DO WHEN YOU FIND A BUG ?
        -Retest to make sure from the failure.It can be data issue, typo, documentation issue or is can be a real bug.
        -If that is a bug, then talk to the dev and let them fix the bug.
        -After the fix, we retest. when test cases passes we upload to JIRA
    ------------------------------------------------
             */




        }
    }
}
