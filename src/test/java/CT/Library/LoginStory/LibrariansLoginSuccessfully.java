package CT.Library.LoginStory;



import CT.Library.utility.ConfigReader;
import CT.Library.utility.Driver;
import CT.Library.utility.TestBase;
import CT.Library.utility.WebDriverUtility;
import CT.Library.utility.WebDriverUtility;
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

            Driver.getDriver().get(ConfigReader.read("url"));

            //Then verify that the title is “Login - Library”
            String expectedResult = "Login - Library";
            String currentResult = Driver.getDriver().getTitle();

           Assertions.assertEquals(expectedResult, currentResult);

           // When librarian enters valid email address and password

            WebElement emailBox = Driver.getDriver().findElement(By.id("inputEmail"));
            emailBox.sendKeys(eachLibrarian);

            WebElement password = Driver.getDriver().findElement(By.id("inputPassword"));
            password.sendKeys("Sdet2022*");


            //And librarian click sign in button
            WebElement signInButton = Driver.getDriver().findElement(By.cssSelector("#login-form > button"));
            signInButton.click();


            //Then verify that there are 3 modules the page
            List<WebElement> modules = Driver.getDriver().findElements(By.xpath("//li[@class='nav-item']"));


            Assertions.assertTrue(modules.size()==3);

            //   user Logs Out because of the loop!
            WebDriverUtility.logout(Driver.getDriver());

        }



    }


}
