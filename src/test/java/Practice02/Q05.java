package Practice02;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Q05 extends TestBase {
    // Go to URL : https://demo.automationtesting.in/Static.html
    // Drag and drop elements.
    @Test
    public void test(){
        // Go to URL : https://demo.automationtesting.in/Static.html
        driver.get("https://demo.automationtesting.in/Static.html");

        //Drag and drop elements.
        //1.locate sources
        WebElement angular=driver.findElement(By.id("angular"));
        WebElement mongo=driver.findElement(By.id("mongo"));
        WebElement node=driver.findElement(By.id("node"));

        //2.locate the taget
        WebElement droparea=driver.findElement(By.id("droparea"));

        //3.Create actions
        Actions actions=new Actions(driver);
        actions.dragAndDrop(angular,droparea).perform();
        actions.dragAndDrop(mongo,droparea).perform();
        actions.dragAndDrop(node,droparea).perform();






    }
}
