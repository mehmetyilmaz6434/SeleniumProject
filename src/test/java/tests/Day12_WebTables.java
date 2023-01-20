package tests;

import Utilities.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Day12_WebTables extends TestBase {
    private static Logger logger=LogManager.getLogger(Day12_WebTables.class.getName());
    @Test
    public void printTableData(){
//        https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables");
        logger.info("printing the webTable information");

//        Create a class: WebTables

//        Task 1 : Print the entire table

        String entireTable=driver.findElement(By.xpath("//table[@id='table1']//thead")).getText();
        System.out.println("Entire Table :"+entireTable);

            List<WebElement> allTablesElements=driver.findElements(By.xpath("//table[@id='table1']//td"));
        for (WebElement eachElement:allTablesElements){
            System.out.println(eachElement.getText());
            logger.info(eachElement.getText());
        }
        System.out.println("5th DATA in the table : "+allTablesElements.get(5).getText());







//        Parameter 1 = row number
//        Parameter 2 = column number
//        printData(2,3);  => prints data in 2nd row 3rd column

    }

    @Test
    public void printRows(){
        //        Task 2 : Print All Rows
        driver.get("https://the-internet.herokuapp.com/tables");

        int rowNum=1;
        List<WebElement> allRows=driver.findElements(By.xpath("//table[@id='table1']//tr"));
        for (WebElement eachRow:allRows){
            System.out.println("Row "+rowNum+" => "+eachRow.getText());
            rowNum++;

        }
        //We can get specific row data
        System.out.println("4th Row Data :"+allRows.get(4).getText());

        // Task 3 : Print Last row data only
        System.out.println("Last row data :"+allRows.get(allRows.size()-1).getText());

    }
    @Test
    public void printColumns(){
        driver.get("https://the-internet.herokuapp.com/tables");
        //Task 4 : Print column 5 data in the table body
        List<WebElement> column5Data=driver.findElements(By.xpath("//table[@id='table1']//tr//td[5]"));
        int colNum=1;
        for (WebElement eachData:column5Data){
            System.out.println("Column "+colNum+"Column5 => "+eachData.getText());
            colNum++;
        }

    }
    public void printData(int rowNum,int colNum){//method oluşturfuk
        String xpath = "//table[@id='table1']//tr["+rowNum+"]//td["+colNum+"]";//değişen kısımları methodun içinde aldık.

    }
    @Test
    public void printDataTest(){
        printData(2,3);
        printData(4,1);

    }
}
