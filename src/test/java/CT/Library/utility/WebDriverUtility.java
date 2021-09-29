package CT.Library.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.PublicKey;
import java.util.ArrayList;

public class WebDriverUtility {


    public static void login (WebDriver driver, String credentials){


            WebElement emailBox = driver.findElement(By.id("inputEmail"));
            emailBox.sendKeys(credentials);

            WebElement password = driver.findElement(By.id("inputPassword"));
            password.sendKeys("Sdet2022*");

            WebElement signInButton = driver.findElement(By.cssSelector("#login-form > button"));
            signInButton.click();


        }




    public static void logout(WebDriver driver) throws InterruptedException {


        WebElement usernameLink = driver.findElement(By.cssSelector("li>a[href='#']"));
        usernameLink.click();

        Thread.sleep(1000);
        WebElement logOutLink = driver.findElement(By.cssSelector("div>a[href='#']"));
        logOutLink.click();


    }





}
