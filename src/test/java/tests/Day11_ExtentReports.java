package tests;

import Utilities.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Day11_ExtentReports extends TestBase {
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @BeforeClass
    public static void extentReportsSetUp(){
        //      REPORT  PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";
//        creating HTML report in the path  (chrome da internet sitesinde bu rapor yazılıyor)
        extentHtmlReporter = new ExtentHtmlReporter(path);
//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();
//        ***************
//        adding custom System Info
        extentReports.setSystemInfo("Test Environment","Regression");//bu part da appl.ismi test ismi gibi kısımlerın kurulumu yapılıyor.
        extentReports.setSystemInfo("Application","TechProEd");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Team","Eagles");
        extentReports.setSystemInfo("SQA","John Fox");
        extentReports.setSystemInfo("Sprint Number","SP205");
//        adding more custom info
        extentHtmlReporter.config().setReportName("TechProEd home page");//DUCUMENT TİTLE NAME
        extentHtmlReporter.config().setDocumentTitle("TechProEd extent reports");
//        ********************
//        DONE WITH CONFIGURATION
        extentReports.attachReporter(extentHtmlReporter);
//        SUMMARY: Extent Reports and Extent HTML Reporter is used to add custom information on the report and create the report in a PATH
//        REPORT IS DONE. NOW CREATING EXTENT TEST TO LOG INFO IN THE TEST CASE
//        Creating extent test
        extentTest= extentReports.createTest("My Extent Reporter","Regression Test Report");
    }
    @Test
    public void extentReportsTest(){
        extentTest.pass("Going to the App Home page");

        driver.get("https://www.techproeducation.com");
        extentTest.pass("User is on Techpro Education home page");

        //click on LMS
        extentTest.pass("Clicking on LMS login button");
        driver.findElement(By.linkText("LMS LOGIN")).click();

        //verify the Url
        extentTest.pass("Verifying the LMS Url");
        String expectedURL ="https://lms.techproeducation.com/";
        String actualURL=driver.getCurrentUrl();
        Assert.assertEquals("LMS LOGIN PAGE IS NOT DISPLAYED",expectedURL,actualURL);
        extentTest.pass("Test is complete");
        //reports==>open in browser==>chrome==>this are reports.
    }
    @Test
    public void setExtentReportsTest2(){
        //pass is used to mark the step as passed
        extentTest.pass("PASS");
        //info is used to just  an information for that step
        extentTest.info("INFO");
        //fail is used to mark the step as FAILED
        extentTest.fail("FAILED");
        //skip is used to mark the step as SKIPPED
        extentTest.skip("SKIPPED");
        //warning is used to give warning information
        extentTest.warning("WARNING");

    }
    @AfterClass
    public static void extentReportsTearDown(){

        //generating the reports
        extentReports.flush();
    }
}
