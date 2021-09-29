package CT.Library.LoginStory;



import CT.Library.utility.ConfigReader;
import CT.Library.utility.Driver;
import CT.Library.utility.TestBase;
import com.github.javafaker.Faker;
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


        Driver.getDriver().get(ConfigReader.read("url"));

        //When student enters invalid email address or password
        WebElement email = Driver.getDriver().findElement(By.id("inputEmail"));

        Faker faker = new Faker();

        email.sendKeys(faker.internet().emailAddress());
        WebElement password = Driver.getDriver().findElement(By.id("inputPassword"));
        password.sendKeys(faker.internet().password());

        //And student click sign in button

        WebElement signInButton = Driver.getDriver().findElement(By.xpath("//button[text()='Sign in']"));
        signInButton.click();


        //Then verify the error message “Sorry, Wrong Email or Password”
        WebElement alert = Driver.getDriver().findElement(By.xpath("//*[text()='Sorry, Wrong Email or Password']"));
        String actualResult = alert.getText();
        String expectedResult = "Sorry, Wrong Email or Password";
        Assertions.assertEquals(expectedResult,actualResult);

        Thread.sleep(2000);





    }
}
