package CT.Library.LoginStory;



import CT.Library.utility.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginWithInvalidCredentials extends TestBase {

    /*
    Given user is on the loginPage

    When user enters invalid email address or password

    And student click sign in button

    Then verify the error message “Sorry, Wrong Email or Password”
     */
    @Test
    public void invalidCredentials() throws InterruptedException {


        driver.get("http://library2.cybertekschool.com/login.html");

        //When student enters invalid email address or password
        WebElement email = driver.findElement(By.id("inputEmail"));
        email.sendKeys("InvalidEmail@gmail.com");
        WebElement password = driver.findElement(By.id("inputPassword"));
        password.sendKeys("Sdet2022*");

        //And student click sign in button

        WebElement signInButton = driver.findElement(By.xpath("//button[text()='Sign in']"));
        signInButton.click();


        //Then verify the error message “Sorry, Wrong Email or Password”
        WebElement alert = driver.findElement(By.xpath("//*[text()='Sorry, Wrong Email or Password']"));
        String actualResult = alert.getText();
        String expectedResult = "Sorry, Wrong Email or Password";
        Assertions.assertEquals(expectedResult,actualResult);

        Thread.sleep(2000);





    }
}
