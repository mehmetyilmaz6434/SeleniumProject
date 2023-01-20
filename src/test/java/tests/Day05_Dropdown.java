package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Day05_Dropdown {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    @Test
    public void selectByIndexTest(){
//    1.select Option
//    1.Way:by index from the dropdown
//        A. locate the dropdown
        WebElement dropdown = driver.findElement(By.id("dropdown"));
//        B. Create Select object cause dropdown is in the select tag. this is for only dropdowns
        Select select = new Select(dropdown);
//        C. Select any option using the select object
        select.selectByIndex(2); // index starts at 0
    }
    //2.Way:Create method selectByVisibleTextTest Select Option 2 by visible text
    @Test
    public void selectByVisibleTextTest(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 2");
    }
    //3.Way:Create method selectByValueTest Select Option 1 value by value
    @Test
    public void selectByValueTest() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        Thread.sleep(3000);//HARD WAIT. WAITS 3 SECONDS
        select.selectByValue("1");
        Thread.sleep(3000);
        select.selectByValue("2");
        Thread.sleep(3000);
        select.selectByValue("1");
        Thread.sleep(3000);
        select.selectByValue("2");
    }
    //2.Create method printAllTest Print all dropdown value
    @Test
    public void printAllTest(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
//        getOptions(); returns all of the dropdown options
        List<WebElement> allOptions = select.getOptions();
        for (WebElement eachOption : allOptions){
//            getText() returns the TEXT of the webelements as STRING
            System.out.println(eachOption.getText());
        }
//    3. Verify the dropdown has Option 2 text
        boolean isOption2Exist=false;
        for (WebElement eachOption : allOptions){
            if (eachOption.getText().equals("Option 2")){
                isOption2Exist=true;
            }
        }
//        fails if Option 2 is not in the dropdown
//        pass if Option 2 is in the dropdown
        Assert.assertTrue(isOption2Exist);
    }

    //4.Create method printFirstSelectedOptionTest Print first selected option
    @Test
    public void printFirstSelectedOptionTest(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
//        printing the selected option
        System.out.println("Selected Option : "+select.getFirstSelectedOption().getText());
//        selecting a different option from the dropdown
        select.selectByIndex(2);
//        printing the selected option
        System.out.println("Selected Option : "+select.getFirstSelectedOption().getText());
//        5.Find the size of the dropdown,
//        Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
        int numberOfOptions = select.getOptions().size();
        int expectedNumberOfOptions = 3;

//        Assertion will print Expected Is Not Equal Actual ONLY IF THIS ASSERTION FAILS
        Assert.assertEquals("Expected Is Not Equal Actual",expectedNumberOfOptions,numberOfOptions);
    }
    @Test
    public void test2(){
        WebElement dropDown=driver.findElement(By.id("dropdown"));
        dropDown.click();
        driver.findElement(By.xpath("(//option[@value='1'])[1]")).click();
    }

//    @After
//    public void tearDown(){
//        driver.quit();
//    }
    }

    /*
    -What is a dropdown?
        ---Dropdown is a webelement. It has list of options.
    -How do you handle dropdown? What do you do to automate dropdown?
        ---Dropdowns are created using Select class. So we first locate the dropdown element, then use select class
        to interact with dropdown elements.
    -How do you select dropdown elements?
        ---We actually have 3 options to select a dropdown(index,value,visible text)
     */



/*
 * How many locators are there?
 * ---8 locator.
 * What are they?
 * ---id, name, className, linkText, tagName, partialLinkText, xpath, css
 * Which one do you prefer? Why?
 * ---Ahmet's answer :
 * -First If there is an ID I use id, because id is unique and faster
 * -If there is no id then I use name if there is a unique name
 * -I also sometimes create dynamic xpath. Because some elements do not have stable attributes like id and name. And I can write xpath for any element.
 * -I sometimes even use css selector instead of xpath. But i personally use xpath more than css.
 * What is difference between absolute xpath and relative xpath?
 * -Absolute xpath we start from the parent and go child elements one by one
 * -Absolute xpath use /
 * -Absolute xpath may easily be broken when a new element is added on the page
 * -For this reason we should never use absolute xpath. In fact, my team don't let QA's use absolute xpath.
 * --Relative xpath we don't start from parent and go child one by one. We go straight to the element
 * --Relative xpath use //
 * --Relative xpath is very reliable It doesn't easy brake, because absolute xpath doesn't dependent on other element
 * --I use absolute xpath in my framework when to locate the elements
 * What is the difference between xpath and css selector?
 * -First xpath and css are similar. Both are helpful and there are different ways to create xpath or css
 * -Syntax is a little different.
 * --in xpath we use // and @, but in css we don't
 * --css is a little faster than xpath(way less than 1 second). xpath does navigation in the html that takes a little bit time
 * --there are more ways to write xpath. For example, dynamic xpath has contains, starts-with, ends-with functions
 * */

