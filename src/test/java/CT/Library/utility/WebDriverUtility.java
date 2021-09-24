package CT.Library.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverUtility {


    public static void logout(WebDriver driver) throws InterruptedException {


        WebElement usernameLink = driver.findElement(By.cssSelector("li>a[href='#']"));
        usernameLink.click();

        Thread.sleep(1000);
        WebElement logOutLink = driver.findElement(By.cssSelector("div>a[href='#']"));
        logOutLink.click();


    }



}
