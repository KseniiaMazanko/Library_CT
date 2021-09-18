package CT.Library.LoginStory;



import CT.Library.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentLoginsSuccessfully extends TestBase {


        /*Given student is on the loginPage

        Then verify that the URL is “https://library2.cybertekschool.com/login.html”

        When student enters valid email address and password

        And student click sign in button

        Then verify that there are 2 modules on the page

         */
    @Test
    public void loginStudent() throws InterruptedException {

        ArrayList<String> studentsCredentials = new ArrayList<>(Arrays.asList("student54@library", "student55@library",
                "student56@library"));

        for (String eachStudent : studentsCredentials) {

            driver.get("http://library2.cybertekschool.com/login.html");

            //Then verify that the URL is “https://library2.cybertekschool.com/login.html”
            String currentResult = driver.getCurrentUrl();
            String expectedResult = "https://library2.cybertekschool.com/login.html";

            Assertions.assertEquals(expectedResult,currentResult);

            //When student enters valid email address and password
            WebElement email = driver.findElement(By.id("inputEmail"));
            email.sendKeys(eachStudent);
            WebElement password = driver.findElement(By.id("inputPassword"));
            password.sendKeys("Sdet2022*");

            //And student click sign in button
            WebElement signInButton = driver.findElement(By.xpath("//button[text()='Sign in']"));
            signInButton.click();

            Thread.sleep(3000);

            //Then verify that there are 2 modules on the page
            List<WebElement> modules = driver.findElements(By.xpath("//li[@class='nav-item']"));

            Assertions.assertTrue(modules.size()==2);

            //   user Logs Out because of the loop!
            WebElement usernameLink = driver.findElement(By.cssSelector("li>a[href='#']"));
            usernameLink.click();

            Thread.sleep(1000);
            WebElement logOutLink = driver.findElement(By.cssSelector("div>a[href='#']"));
            logOutLink.click();


        }









    }


}
