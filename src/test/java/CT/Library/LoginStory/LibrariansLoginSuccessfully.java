package CT.Library.LoginStory;



import CT.Library.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibrariansLoginSuccessfully extends TestBase {




        //librarian43@library
        //librarian18@library

       /* Given librarian is on the loginPage

        Then verify that the title is “Login - Library”

        When librarian enters valid email address and password

        And librarian click sign in button

        Then verify that there are 3 modules the page

        */

    @Test
            public void LoginLibrarian() throws InterruptedException {

        ArrayList<String> librariansCredentials = new ArrayList<>(Arrays.asList("librarian43@library","librarian18@library"));
        for (String eachLibrarian : librariansCredentials) {

            driver.navigate().to("http://library2.cybertekschool.com/login.html");

            //Then verify that the title is “Login - Library”
            String expectedResult = "Login - Library";
            String currentResult = driver.getTitle();

           Assertions.assertEquals(expectedResult, currentResult);

           // When librarian enters valid email address and password

            WebElement emailBox = driver.findElement(By.id("inputEmail"));
            emailBox.sendKeys(eachLibrarian);

            WebElement password = driver.findElement(By.id("inputPassword"));
            password.sendKeys("Sdet2022*");


            //And librarian click sign in button
            WebElement signInButton = driver.findElement(By.cssSelector("#login-form > button"));
            signInButton.click();


            //Then verify that there are 3 modules the page
            List<WebElement> modules = driver.findElements(By.xpath("//li[@class='nav-item']"));


            Assertions.assertTrue(modules.size()==3);

            //   user Logs Out because of the loop!
            WebElement usernameLink = driver.findElement(By.cssSelector("li>a[href='#']"));
            usernameLink.click();

            Thread.sleep(1000);
            WebElement logOutLink = driver.findElement(By.cssSelector("div>a[href='#']"));
            logOutLink.click();

        }



    }


}
