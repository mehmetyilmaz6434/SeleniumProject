package tests;

import org.junit.Assert;//Assert is class
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;//method

public class Day03_Assertions {
    @Test
    public void assertions(){
        /*
        we need to use assertions to do manual testing.Else we are just going to do manual testing.
        What is assertion in testing?
    Assertion is done to check if the expected data is equal to actual data.
    -expected == actual ==> PASS
    -expected != actual ==> FAIL

    -------------
    assertEquals("expected" , "actual") --> If expected is equal to actual, it will PASS otherwise it will FAIL.

    assertTrue(true)=> PASS
    assertTrue(false)=> FAIL

    assertFalse(false)=> PASS
    assertFalse(true)=> FAIL

         */
        Assert.assertEquals(2,2);//Pass
       // Assert.assertEquals("Values did not match",1,2);//Fail

        assertTrue(true);//PASS
        // assertTrue(false);//FAIL
        //assertTrue(1==2);//İt is not complined.
        // assertTrue(12);  //İt is complined.

        int a=3;
        int b=5;
        //assertTrue(a==b);//FAIL
        assertFalse(a==b);//PASS   if condition is False, it will pass.
        assertFalse(a>b); //PASS   Because a>b is false. false==false==>true==>PASS

        String name="John";
        assertTrue(name.contains("J")); //PASS
        assertFalse(name.contains("A"));//PASS   ==>it might be negative test.

        if (name.contains("X")){    //is Verification.==>soft assertion
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed!!!");

        }

        /*

        What is the difference between Assertion and Verification?
        Assertion stops the execution in failure. Verification continues even after failure.
        JUnit assertions are hard assertions. If statement is verification.

        Hard Assertion : If the execution stops in failure it is call Hard Assertion
        Verification : If the execution continues in failure it is call Verification.

         */

        /*
                                             WEB ELEMENTS
      Anything on the webpage is called webElement like Button, search box...
      There are different type of WebElement tags like <html>,<body>...
      Together they create a webpage on UI.

      How to inspect Page for finding webelements.==>right botton==>inspect(incele)
      this inspect might be unique.
      <input type="text id">  ==>input  :tag name
                                 type   :attiribute name
                                 text id: attiribute value
      LOCATORS
      for automation we have 2 steps.
      1)Identify the element==>selenıum identfies the elements using locators like id,name, class name....etc
      2)perform the actions such as click,submit....etc.
      selenium has 8 locator to locate elements:id,name,className, tagName,linkTest,partialLinkTest,
                                                xpath,css
      we use locators to find element on webpage.
      id:is usually unique. used to locate an element.
      driver.findElement(By.id("...."));


         */




    }

}
