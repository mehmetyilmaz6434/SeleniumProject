package Practice04;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Q01 extends TestBase {
    @Test
    public void test(){

// Go to  https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");


// Enter the username  as "standard_user"
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

// Enter the password as "secret_sauce"
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

// Click on login button
      driver.findElement(By.id("login-button")).click();

// Add all products to cart
        List<WebElement> addToCartButton=driver.findElements(By.xpath("//button[.='Add to cart']"));
        for (WebElement eachButton:addToCartButton){
            eachButton.click();
        }
// Go to cart
      driver.findElement(By.id("shopping_cart_container"));

// Click on checkout
        driver.findElement(By.id("checkout")).click();

// Fill your information



// Click on continue

// Assert that total price is $140.34

// Click on finish

// Assert that CHECKOUT: COMPLETE!


    }



}









