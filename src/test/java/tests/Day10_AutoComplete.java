package tests;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Day10_AutoComplete extends TestBase {

    @Test
    public void AutoCompleteTest(){
        //    Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");

        //    When user type “uni” in the search box
        WebElement dropDown=driver.findElement(By.id("myCountry"));
        dropDown.sendKeys("uni");

        //    And select the ‘United Kingdom’ from the suggestions
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']")).click();

        //    And click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();

        //    Then verify the result contains ‘United Kingdom’
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("United Kingdom"));

        //    Then verify the result contains ‘United Kingdom’

    }
    @Test
    public void autoCompleteTestWithReusableMethod() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
        searchAndSelectFromList("uni","United Kingdom");//Test Case 1

        searchAndSelectFromList("bah","Bahamas");//Test Case 2
    }

}
