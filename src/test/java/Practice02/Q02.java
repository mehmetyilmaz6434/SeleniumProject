package Practice02;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Q02 extends TestBase {
    /*
    Given
        Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    When
        Click on the "Animals and Nature" emoji
    And
        Click all the "Animals and Nature"  emoji elements
    And
        Fill the form
    And
        Press the apply button
    Then
        Verify "code" element is displayed
     */
    @Test
    public void test(){
        //Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        //First switch to iFrame
        WebElement iFrame=driver.findElement(By.id("emoojis"));
        driver.switchTo().frame(iFrame);

        //Click on the "Animals and Nature" emoji
        driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]")).click();
        //Note: when I run the code test does not pass so we control an iFrame if there is exist or not.
        //iFrame page is inside a parent page.sometimes it is not seen visible.Then we need to control if it is exist.

        //Click all the "Animals and Nature"  emoji elements
        List<WebElement> allEmojis=driver.findElements(By.xpath("//div[@id='nature']/div/img"));

        //        for (WebElement w:allEmojis){
        //            w.click();
        //        }

        allEmojis.forEach(WebElement::click);//Lambda is recommended.

        //Get out of the iFrame  Because the form is out of the iFrame.
        driver.switchTo().defaultContent();

        //Fill the form
        List<WebElement> inputs=driver.findElements(By.xpath("//input"));//there are 11 elements in the path.
        List<String> words=new ArrayList<>(Arrays.asList("This","iFrame","example","looks","really","funny","does","not","it","?","!"));


        for(int i = 0; i<inputs.size();i++){

            inputs.get(i).sendKeys(words.get(i));

        }

        //Click the apply button
        driver.findElement(By.id("send")).click();

        //Verify "code" element is displayed
        WebElement code = driver.findElement(By.id("code"));
        assertTrue(code.isDisplayed());









        //


    }
}
