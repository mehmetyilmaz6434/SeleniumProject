package tests;

import Utilities.TestBase;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class Day05_ZHomework extends TestBase {
    @Test
    public void testHomework() {

        //Go to https://www.amazon.com/
        driver.get("https://www.amazon.com/");


        //Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));

        //Print the first selected option and assert if it equals “All Departments”.If it fails, then comment that code out and continue rest of the test case.
        Select select= new Select(dropdown);

        String firstSelectedOption = select.getFirstSelectedOption().getText();
        if (firstSelectedOption.equals("All Departments")) {
            System.out.println("PASS");

        }else {
            System.out.println("FAIL");

        }
        //Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
        // (after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
        select.selectByIndex(3);
        String actualResult=select.getFirstSelectedOption().getText();
        String expectedResult="Baby";

        assertEquals("Test Failed",expectedResult,actualResult);

        //Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
        List<WebElement> alloptions=select.getOptions();
        for (WebElement printAllOptions: alloptions){
            System.out.println(printAllOptions.getText());
        }

        //Print the the total number of options in the dropdown
        int numOfOptions=alloptions.size();
        System.out.println(numOfOptions);

        //Assert if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
       List<String> listOfOptions=new ArrayList<>();
       for (WebElement eachOptions:alloptions){
           listOfOptions.add(eachOptions.getText());
       }
        System.out.println("listOfOptions : "+listOfOptions);
        if (listOfOptions.contains("Appliances")){
            System.out.println("True");
        }else{
            System.out.println("False");
        }

        //BONUS: Assert if the dropdown is in Alphabetical Order
        List<String> sortedList=listOfOptions.stream().sorted().collect(Collectors.toList());
        System.out.println("sortedList : "+sortedList);
        assertEquals("Dropdown is not alphabetical order ",listOfOptions,sortedList);

    }

    @Test
    public void homework2(){
        //        When user goes to https://www.google.com/
        driver.get("https://www.google.com/");

        //        Search for “porcelain teapot”
        driver.findElement(By.xpath("(//input[@class='gNO89b'])[1]")).click();
        driver.findElement(By.id("input")).sendKeys("porcelain teapot"+Keys.ENTER);

        //        And print how many related results displayed on Google
        System.out.println(driver.findElement(By.id("result-stats")).getText());















    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
