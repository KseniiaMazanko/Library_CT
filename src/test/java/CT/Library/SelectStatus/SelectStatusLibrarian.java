package CT.Library.SelectStatus;


import CT.Library.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectStatusLibrarian extends TestBase {

    /*
    As a librarian, I want to select user status - active vs inactive.


    AC #1:
    Given librarian is on the homePage
    When librarian click Users module
    And librarian click Status dropdown
    Then verify there are 2 status options

     */

    @Test
    public void verifyStatus1() throws InterruptedException {

        ArrayList<String> librariansCredentials = new ArrayList<>(Arrays.asList("librarian43@library", "librarian18@library"));

        for (String eachLibrarian : librariansCredentials) {

            //Given librarian is on the homePage

            driver.get("http://library2.cybertekschool.com/login.html");

            WebElement emailBox = driver.findElement(By.id("inputEmail"));
            emailBox.sendKeys(eachLibrarian);

            WebElement password = driver.findElement(By.id("inputPassword"));
            password.sendKeys("Sdet2022*");

            WebElement signInButton = driver.findElement(By.cssSelector("#login-form > button"));
            signInButton.click();


            //When librarian click Users module
            WebElement userModule = driver.findElement(By.xpath("//li/a[@href='#users']"));
            userModule.click();


            //And librarian click Status dropdown
            WebElement statusSelect = driver.findElement(By.id("user_status"));
            statusSelect.click();


            Select statusObj = new Select(statusSelect);
            List<WebElement> listOfStatuses = statusObj.getOptions();


            //Then verify there are 2 status options
            Assertions.assertTrue(listOfStatuses.size()==2);


            //   user Logs Out because of the loop!
            WebElement usernameLink = driver.findElement(By.cssSelector("li>a[href='#']"));
            usernameLink.click();

            Thread.sleep(1000);
            WebElement logOutLink = driver.findElement(By.cssSelector("div>a[href='#']"));
            logOutLink.click();

        }


    }

}
