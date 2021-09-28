package CT.Library.AddNewUser;

import CT.Library.utility.TestBase;
import CT.Library.utility.WebDriverUtility;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;

public class AddNewUserLibrarian extends TestBase {


    //MAKE SURE TO CHANGE THE EMAIL FOR EVERY NEW TEST TO AVOID THE ERROR 'EMAIL ALREADY EXIST'

    /*
    Given librarian is on the homePage

    When librarian click Users module

    And librarian click “+Add User” button

    When librarian enter full name, password, email and address

    And librarian click save changes

    Then verify a new user is created

     */


//
        @Test
        public void addNewUser() throws InterruptedException {
        ArrayList<String> librariansCredentials = new ArrayList<>(Arrays.asList("librarian43@library","librarian18@library"));

        for (String eachLibrarian : librariansCredentials) {

            driver.navigate().to("http://library2.cybertekschool.com/login.html");

            //Given librarian is on the homePage

            WebDriverUtility.login(driver, eachLibrarian);

            //verifying before count
            String beforeAddingAUser = driver.findElement(By.cssSelector("#user_count")).getText();
            int numberBefore = Integer.parseInt(beforeAddingAUser);
            System.out.println("numberBefore = " + numberBefore);


            //When librarian click Books module
            WebElement usersModule = driver.findElement(By.xpath("//*[text()='Users']"));
            usersModule.click();


            //    And librarian click “+Add User” button
            //generating fake data
            Faker faker = new Faker();

            WebElement addANewUser = driver.findElement(By.xpath("//span/a"));
            addANewUser.click();

            //When librarian enter full name, password, email and address

            WebElement fullName = driver.findElement(By.xpath("//input[@type='text' and @name='full_name']"));
            fullName.sendKeys(faker.name().fullName());

            WebElement passwordUser = driver.findElement(By.cssSelector("input[name='password']"));
            passwordUser.sendKeys(faker.internet().password());


            WebElement email = driver.findElement(By.cssSelector("input[name='email']"));
            email.sendKeys(faker.internet().emailAddress());

            WebElement userGroup = driver.findElement(By.id("user_group_id"));
            Select objGroup = new Select(userGroup);
            objGroup.selectByValue("3");

            WebElement status = driver.findElement(By.id("status"));
            Select objStatus = new Select(status);
            objStatus.selectByVisibleText("ACTIVE");

            WebElement address = driver.findElement(By.id("address"));
            address.sendKeys(faker.address().fullAddress());

            Thread.sleep(3);

            //And librarian click save changes

            WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
            submitBtn.submit();

            Thread.sleep(4000);

            driver.navigate().to("https://library2.cybertekschool.com/#dashboard");
            driver.navigate().refresh();
            Thread.sleep(3000);

            //Then verify a new user is created

            String afterAddingTheUser = driver.findElement(By.cssSelector("#user_count")).getText();
            int numberAfter = Integer.parseInt(afterAddingTheUser);
            System.out.println("numberAfter = " + numberAfter);


            Assertions.assertTrue(numberAfter==numberBefore+1);

            //   user Logs Out because of the loop
            WebDriverUtility.logout(driver);


        }

    }
}




