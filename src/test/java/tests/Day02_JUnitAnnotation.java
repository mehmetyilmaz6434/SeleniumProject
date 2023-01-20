package tests;

import org.junit.*;

public class Day02_JUnitAnnotation {
    /*
     * So far we kept using main method
     * We no longer need to use main method to create test cases with JUnit
     * -@Test : is used to create test cases
     * NOTE: All @Test methods must be void
     * -@Before: Runs before each @Test class. This is used to run repeated pre conditions.(Her bir tessten önce çalışır.)
     * For example, setup, create driver, maximize window
     * -@After : Runs after each @Test class. This is used to run repeated after condition
     * For example, driver quit, report generation
     * -@BeforeClass : Runs before each CLASS only ONCE. This method must be static
     * -AfterClass   : Runs after each CLASS only ONCE. This method must be static
     * */

    @BeforeClass
    public static void setUpClass(){
        System.out.println("Before Class Runs before the entire class ONCE");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("After Class Runs after the entire class ONCE");
    }
    @Before
    public void setUp(){
        System.out.println("Before Method Runs before each @Test annotation");
    }
    @After
    public void tearDown(){
        System.out.println("After Method Runs after each @Test annotation");
    }

    @Test
    public void test01(){
        System.out.println("Test 1");
    }
    @Test
    public void test02(){
        System.out.println("Test 2");
    }
    @Test @Ignore
    public void test03(){
        System.out.println("Test 3");
    }
    @Test
    public void test04(){
        System.out.println("Test 4");
    }
    @Test
    public void test05(){
        System.out.println("Test 5");
    }

}
