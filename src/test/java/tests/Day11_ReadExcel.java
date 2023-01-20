package tests;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day11_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {

//        Import the apache poi dependency in your pom file
//        Create resources directory under java folder(right click on java and create the folder)
//        Add the excel file on the resources folder
//        Create a new package: excelautomation
//        Create a new class : ReadExcel
//        Create a new test method : readExcel()
//        Store the path of the  file in a string
        String path="./src/test/java/resources/Capitals.xlsx";
//        Open the file
        FileInputStream fileInputStream=new FileInputStream(path);
//        Open the workbook using fileinputstream
        Workbook workbook= WorkbookFactory.create(fileInputStream);
//        Open the first worksheet (indexes start at "0")
        Sheet sheet1=workbook.getSheet("Sheet1");//   or  "workbook.getSheetAt(0);" can be typed.
//        Go to first row
        Row row1=sheet1.getRow(0);
//        Go to first cell on that first row and print
        Cell cell1=row1.getCell(0);//index starts at 0. reading the first cell data that is on the first row
        System.out.println(cell1);

        String cell1Data=cell1.toString();
        System.out.println(cell1Data);
//        Go to second cell on that first row and print
        Cell r1c1=row1.getCell(1);
        System.out.println("r1c1 :"+r1c1.toString());
//        Go to 2nd row first cell  and assert if the data equal to USA
        String r2c1=sheet1.getRow(1).getCell(0).toString();
        Assert.assertEquals("USA",r2c1);
//        Go to 3rd row 2nd cell-chain the row and cell
        String r3c2=sheet1.getRow(2).getCell(1).toString();
        System.out.println(r3c2);
//        Find the number of row,
        int numOfRows=sheet1.getLastRowNum()+1;//index starts at 0 ,so add 1 to find total number of the rows.
        System.out.println("ROW COUNT :"+numOfRows);
//        Find the number of used row
        int physicalNumberOfRows=sheet1.getPhysicalNumberOfRows();
        System.out.println("Number of data :"+physicalNumberOfRows);
//        Print country, capitol key value pairs as map object
        Map<String,String> contryCapitals=new HashMap<>();
        for (int rowNum=1;rowNum<numOfRows;rowNum++){//row index starts at 1, ends at 11
            String country=sheet1.getRow(rowNum).getCell(0).toString();
            String capitals=sheet1.getRow(rowNum).getCell(1).toString();
            contryCapitals.put(country,capitals);

        }
        System.out.println(contryCapitals);



    }
}
