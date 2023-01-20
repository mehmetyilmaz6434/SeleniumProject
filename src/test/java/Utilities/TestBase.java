package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {  //Testbase testbase=mew testbase(); abstract ile bu objeyi oluşturmaya ihtiyaç duymuyoruz.
    protected static WebDriver driver;//we use protected because default access modifier can not be seen from another package.
    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }
//    @After
//   public void tearDown(){
//        driver.quit();
//    }

    //    AUTO COMPLETE REUSABLE METHOD
    //    THIS CODE IS USED FOR SELECTING AND VERIFYING OUR APP AUTO COMPLETE SEARCH FUNCTIONALITY
    //    This method is going to accept the keyword and select the dropdown. it is more useful.
    //    NOTE: THIS REUSABLE METHOD DESIGNED FOR OUR CURRENT PROJECT. THIS MAY NOT WORK FOR NEW PROJECTS, BUT CAN BE MODIFIED AND USED FOR THAT NEW PROJECT
    //    NOTE: YOU WILL SEE THIS KIND OF REUSABLE METHOD THAT IS SPECIFIC TO YOUR OWN PROJECT
    //    THE POINT OF REUSABLE METHOD IS : WRITE ONCE USE MULTIPLE TIMES TO SAVE TIME AND SHORT TEST CLASS
    public static void searchAndSelectFromList(String keyword, String textFromList) throws InterruptedException {
        //searchAndSelectFromList('uni','United Kingdom');

        Thread.sleep(2000);
        //Sending a KEYWORD DYNAMICALLY using PARAMETER 1
        driver.findElement(By.id("myCountry")).sendKeys(keyword);//uni
        Thread.sleep(2000);
        //Selecting an option from the list DYNAMICALLY using PARAMETER 2
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='"+textFromList+"']")).click();//United Kingdom
        Thread.sleep(2000);
        //Nothing special. Just clicking on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();//click on submit button
        Thread.sleep(2000);
        //Verifying if result contains the option that I selected DYNAMICALLY using PAREMETER 2
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains(textFromList));


    }
    //    TAKE SCREENSHOT OF ENTIRE PAGE WITH THIS REUSABLE METHOD
    public static void takeScreenshotOfPage() throws IOException {
        // 1. Take screenshot using getScreenshotAs method and TakeScreenshot API-coming from selenium
        File image=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        // 2.Creating a PATH and dynamic name for the image
        String currentTime=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//getting the current local date and time
        //Path is where we save the screenshot.PROJECT/FOLDER    /FOLDER     /NAME OF IMAGE  .png
         String path=System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";//Where we save the image

        //3.Saving the IMAGE in the PATH
        FileUtils.copyFile(image,new File(path));

    }
    //    TAKE SCREENSHOT OF SPECIFIC ELEMENT
    public void takeScreenshotOfPageTheElement(WebElement element) throws IOException {
        //take screenshot
        File image=element.getScreenshotAs(OutputType.FILE);
        // 2. Creating a PATH and dynamic name for the image
        String currentTime=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//getting the current local date and time
        //Path is where we save the screenshot.PROJECT/FOLDER    /FOLDER     /NAME OF IMAGE  .png
        String path=System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";//Where we save the image
        //3.Saving the IMAGE in the PATH
        FileUtils.copyFile(image,new File(path));


    }
    public static void waitFor(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //Scroll Into a view of an element By Javascript
     /*
    JAVASCRIPT EXECUTOR
    @param WebElement
    Accepts a web element and scrolls into that element
     We may need to scroll for capturing the screenshots property
    We may need to scroll to specific elements with js executor
    because some elements may not LOAD properly
    unless we scroll to that elements
     */
    public void scrollIntoViewByJs(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",element);
    }
    /*
    scroll the page all the down
     */
    public void scrollAllTheWayDownByJS(){
        JavascriptExecutor js=(JavascriptExecutor)driver;
      js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    /*
    scroll the page all the up
     */
    public void scrollAllTheWayUpByJS(){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }
    /*
    click on an element
    @param WebElement
    Normally we use element.click() method in selenium
    When there is an issue with click()-hidden, different UI, ...
    Then we can use javascript click that works better
     */
    public void clickByJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",element);
    }
    /*
    @param : WebElement, String
    Types the string in the WebElement
    element.sendKeys("text") to type in an input
    ALTERNATIVELY we can use use js executor to type in an input
    arguments[0].setAttribute('value','admin123');  -> SAME AS element.sendKeys("admin123")

    INTERVIEW QUESTION : What are the selenium methods that you use to type in an input?
    - sendKeys()
    - with javascript executor we can change the value of the input
     */
    public void setValueByJS(WebElement element, String text) {//içinde değer olan kutuyu silmeden değiştirme metodu.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }
    /*
    param:Id of the element
     */
    public void getValueByJS(String idOfElement){//içinde değer olan kutuyu silmeden alma metodu.(Id kullanılarak)
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String value=js.executeScript("return document.getElementById('"+idOfElement+"').value").toString();
        System.out.println(value);
//        How you get the value of an input box?
//        We can js executor.
//        How?
//        I can get the element using js executor, and get teh value of the element.
//        For example, I can get the element by id, and use value attribute to get the value of in an input
//        I have to do this, cause getText in this case does not return teh text in an input
    }
    //    Changes the changeBackgroundColorByJS of an element. Params: WebElement element, String color. NOT COMMON
    public void changeBackgroundColorByJS(WebElement element, String color){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
    }
    //    NOT COMMON
    public void addBorderWithJS(WebElement element, String borderStyle){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.border='"+borderStyle+"'",element);
    }









    //Dynamic Waits:

    //-----------Expilicit Waits----------

    public static WebElement waitForVisibility(WebElement element,int durationOfSec){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationOfSec));
        WebElement helloWorld=wait.until(ExpectedConditions.visibilityOf(element));
        return  helloWorld;

    }
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    //Hard Wait with loop
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }
    //-----------Fluent Wait-----------
    //@params: String xPath of web element, int total time of wait, int polling every period
    public static WebElement fluentWait(String xpath,int withTimeout,int pollingEvery){
        Wait<WebDriver> wait=new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(withTimeout)).//Total Wait
                        pollingEvery(Duration.ofSeconds(pollingEvery)).//Checking Period of Web Element==>Ths will check the web element in each 2 secs.
                        withMessage("Ignoring No such ElementException").//Optionals:Giving Custom Message
                        ignoring(NoSuchElementException.class);//Optionals:Ignoring Exception
        //2.Step: Use wait object,apply wait.
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));


    }
    //    This can be used when a new page opens
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println("Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }








}
