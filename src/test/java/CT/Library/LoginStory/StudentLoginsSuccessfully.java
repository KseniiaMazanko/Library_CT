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

            Driver.getDriver().get(ConfigReader.read("url"));

            //Then verify that the URL is “https://library2.cybertekschool.com/login.html”
            String currentResult = Driver.getDriver().getCurrentUrl();
            String expectedResult = "https://library2.cybertekschool.com/login.html";

            Assertions.assertEquals(expectedResult,currentResult);

            //When student enters valid email address and password
            WebElement email = Driver.getDriver().findElement(By.id("inputEmail"));
            email.sendKeys(eachStudent);
            WebElement password = Driver.getDriver().findElement(By.id("inputPassword"));
            password.sendKeys("Sdet2022*");

            //And student click sign in button
            WebElement signInButton = Driver.getDriver().findElement(By.xpath("//button[text()='Sign in']"));
            signInButton.click();

            Thread.sleep(3000);

            //Then verify that there are 2 modules on the page
            List<WebElement> modules = Driver.getDriver().findElements(By.xpath("//li[@class='nav-item']"));

            Assertions.assertTrue(modules.size()==2);

            //   user Logs Out because of the loop!
            WebDriverUtility.logout(Driver.getDriver());


        }









    }


}
