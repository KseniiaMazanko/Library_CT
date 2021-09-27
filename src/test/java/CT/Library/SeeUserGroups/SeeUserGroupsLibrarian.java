package CT.Library.SeeUserGroups;


import CT.Library.utility.TestBase;
import CT.Library.utility.WebDriverUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeeUserGroupsLibrarian extends TestBase {

    /*

    As a librarian, I want to select user groups.

    AC #1:
    Given librarian is on the homePage
    When librarian click Users module
    And librarian click user group dropdown
    Then verify librarian have 3 options

     */

    @Test
    public void userGroup() throws InterruptedException {

        ArrayList<String> credentials = new ArrayList<>(Arrays.asList("librarian43@library", "librarian18@library"));

        for (String eachUser : credentials) {

            driver.get("http://library2.cybertekschool.com/login.html");

           WebDriverUtility.login(driver, eachUser);

            //Given user is on the homePage
            Thread.sleep(2000);
            //When librarian click Users module


            WebElement userModule = driver.findElement(By.xpath("//li/a[@href='#users']"));
            userModule.click();

            //And librarian click user group dropdown

            WebElement groupSelect = driver.findElement(By.id("user_groups"));
            groupSelect.click();


            //Then verify librarian have 3 options
            Select selectObj = new Select(groupSelect);
            List<WebElement> groupOptions = selectObj.getOptions();

            Assertions.assertTrue(groupOptions.size()==3);

            //   user Logs Out because of the loop

            WebDriverUtility.logout(driver);

        }
    }
}
