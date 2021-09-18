package CT.Library.FilterBookCategories;


import CT.Library.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectDramaOption_VerifyAmountOfCategories extends TestBase {


    /*
    As a user, I want to filter book categories.

    AC #1:
    Given user is on the homePage
    When user click Books module
    And user click book category dropdown
    Then verify there are 21 options

    AC #2:
    Given user is on the homePage
    When user click Books module
    And user click book category dropdown
    Then verify user is able to selected the “Drama” option


    Create total 2 test cases , 1 test execution on jiraNote:
    AC#1&2 are requiring to test if both Librarian & Students can use
    the book categories as expected.
    Since both users have the SAME STEP & EXPECTED RESULT,
    we only need to create ONE test case for each AC.
     */

    @Test
    public void selectDramaOpt() throws InterruptedException {

        ArrayList<String> credentials = new ArrayList<>(Arrays.asList("librarian43@library", "librarian18@library",
                "student54@library", "student55@library", "student56@library") );

        for (String eachUser : credentials) {

            driver.get("http://library2.cybertekschool.com/login.html");

            WebElement emailBox = driver.findElement(By.id("inputEmail"));
            emailBox.sendKeys(eachUser);

            WebElement password = driver.findElement(By.id("inputPassword"));
            password.sendKeys("Sdet2022*");

            WebElement signInButton = driver.findElement(By.cssSelector("#login-form > button"));
            signInButton.click();

            //Given user is on the homePage

            //When user click Books module
            WebElement booksModule = driver.findElement(By.xpath("//*[text()='Books']"));
            booksModule.click();

            //And user click book category dropdown
            WebElement bookCategories = driver.findElement(By.id("book_categories"));
            bookCategories.click();

            //locating the ListOfCategories
            Select categoriesObj = new Select(bookCategories);
            List<WebElement> listOfCategories = categoriesObj.getOptions();

            //Then verify user is able to selected the “Drama” option
            Select categoryObj = new Select(bookCategories);
            categoryObj.selectByValue("6");

            //Then verify there are 21 options and "Drama" is selected
            Assertions.assertTrue(categoryObj.getFirstSelectedOption().getText().equals("Drama")&&listOfCategories.size()==21);

            //   user clicks Log Out
            WebElement usernameLink = driver.findElement(By.cssSelector("li>a[href='#']"));
            usernameLink.click();

            Thread.sleep(1000);
            WebElement logOutLink = driver.findElement(By.cssSelector("div>a[href='#']"));
            logOutLink.click();

        }
    }
}
