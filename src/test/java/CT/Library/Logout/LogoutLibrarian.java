package CT.Library.Logout;



import CT.Library.utility.TestBase;
import CT.Library.utility.WebDriverUtility;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutLibrarian extends TestBase {

    /*
    As a librarian, I want to logout from the library homepage.

    AC #1:
    Given user is on the homePage
    When user click username on the right top corner
    And user click Log Out
    Then verify user navigate back to login page.

     */

    @Test
    public void logout() throws InterruptedException {

        ArrayList<String> librariansCredentials = new ArrayList<>(Arrays.asList("librarian43@library", "librarian18@library"));
        for (String eachLibrarian : librariansCredentials) {


            //String librarian1 = "librarian43@library";

            driver.get("http://library2.cybertekschool.com/login.html");

            WebDriverUtility.login(driver, eachLibrarian);

            //Given user is on the homePage
            Thread.sleep(3000);

            //When user click username on the right top corner

            WebElement usernameLink = driver.findElement(By.cssSelector("li>a[href='#']"));
            usernameLink.click();

            //    And user click Log Out

            Thread.sleep(1000);
            WebElement logOutLink = driver.findElement(By.cssSelector("div>a[href='#']"));
            logOutLink.click();

            Thread.sleep(3000);

            //Then verify user navigate back to login page.

            String expectedResult = "https://library2.cybertekschool.com/login.html";
            String actualResult = driver.getCurrentUrl();

            //THIS works yay!
            assertEquals(expectedResult,actualResult);

        }



    }
}








