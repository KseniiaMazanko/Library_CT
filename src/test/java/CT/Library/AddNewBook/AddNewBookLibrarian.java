package CT.Library.AddNewBook;

import CT.Library.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;

public class AddNewBookLibrarian extends TestBase {

    /*
    Given librarian is on the homePage

    When librarian click Books module

    And librarian click “+Add Book” button

    When librarian enter BookName, ISBN, Year, Author, and Description

    And librarian click save changes

    Then verify a new book is added
     */

    @Test
    public void addBook() throws InterruptedException {


        ArrayList <String> librariansCredentials = new ArrayList<>(Arrays.asList("librarian43@library","librarian18@library"));

        for (String eachLibrarian : librariansCredentials) {

            //Given librarian is on the homePage
            driver.navigate().to("http://library2.cybertekschool.com/login.html");

            WebElement emailBox = driver.findElement(By.id("inputEmail"));
            emailBox.sendKeys(eachLibrarian);

            WebElement password = driver.findElement(By.id("inputPassword"));
            password.sendKeys("Sdet2022*");


            WebElement signInButton = driver.findElement(By.cssSelector("#login-form > button"));
            signInButton.click();

            //When librarian click Books module
           WebElement booksModule = driver.findElement(By.xpath("//*[text()='Books']"));
           booksModule.click();


            //And librarian click “+Add Book” button
           WebElement addBook = driver.findElement(By.xpath("//*[@id=\"books\"]/div[1]/div[1]/span/a"));
           addBook.click();


            //When librarian enter BookName, ISBN, Year, Author, and Description
            WebElement book = driver.findElement(By.name("name"));
            book.sendKeys("Rich Dad Poor Dad");

            WebElement ISBN = driver.findElement(By.name("isbn"));
            ISBN.sendKeys("9780446677455");

            WebElement year = driver.findElement(By.name("year"));
            year.sendKeys("1997");

            WebElement author = driver.findElement(By.xpath("//*[@id=\"add_book_form\"]/div[1]/div/div[2]/div[1]/div/input"));
            author.sendKeys("Robert Kiyosaki");

            WebElement genre = driver.findElement(By.id("book_group_id"));
            Select genreObj = new Select(genre);
            genreObj.selectByValue("14");

            WebElement description = driver.findElement(By.id("description"));
            description.sendKeys("The book advocates the importance of financial literacy");

            Thread.sleep(2000);

            WebElement saveChanges = driver.findElement(By.cssSelector("button[type='submit']"));
            saveChanges.click();

            //locating the pop up message to verify if the book was added
            WebElement successMessage = driver.findElement(By.xpath("//div/div[@class= 'toast-message']"));
            String actualResult = successMessage.getText();
            String expectedResult = "The book has been created.";

            Assertions.assertEquals(expectedResult,actualResult);
            Thread.sleep(7000);


            //   user Logs Out because of the loop
            WebElement usernameLink = driver.findElement(By.cssSelector("li>a[href='#']"));
            usernameLink.click();

            Thread.sleep(1000);
            WebElement logOutLink = driver.findElement(By.cssSelector("div>a[href='#']"));
            logOutLink.click();



            //second approach to verify if the book was created by checking the before and after count
             /*
             //verifying before count
            String beforeAddingABook = driver.findElement(By.cssSelector("[id='book_count']")).getText();
            int numberBefore = Integer.parseInt(beforeAddingABook);
            System.out.println("numberBefore = " + numberBefore);
             */

            /*
            //verifying after count
            driver.get("https://library2.cybertekschool.com/login.html");
            driver.navigate().refresh();
            Thread.sleep(5000);

            String afterAddingABook = driver.findElement(By.cssSelector("[id='book_count']")).getText();
            int numberAfter = Integer.parseInt(afterAddingABook);
            System.out.println("numberAfter = " + numberAfter);

            Assertions.assertTrue(numberBefore==numberAfter-1);
             */







            //never mind this
            /*
            Alert alert = driver.switchTo().alert(); // switch to alert
            String alertMessage= driver.switchTo().alert().getText(); // capture alert message
            System.out.println(alertMessage); // Print Alert Message
            Thread.sleep(5000);
             */

        }



    }
}
