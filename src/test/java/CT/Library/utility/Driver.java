package CT.Library.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    //private static field with name obj
    private static WebDriver obj;

    //create private constructor no args
    private Driver() {
    }

    /*
    create public static method
     name : getDriver()
     return type :WebDriver
     param : none

     check if obj is null or not
         if yes - create ChromeDriver with all set up
        if no  -- return same obj
     */

    public static WebDriver getDriver() {

        String browserName = ConfigReader.read("browser");

        if (obj == null) {

            switch (browserName.toLowerCase().trim()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    obj = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    obj = new FirefoxDriver();
                    break;

                default:
                    obj = null;
                    System.out.println("UNKNOWN BROWSER TYPE! " + browserName);
            }
            return obj;
        } else {
            return obj;
            //because the obj already exists
        }

    }


    public static void closeBrowser() {

        // check if we have WebDriver instance or not
        // basically checking if obj is null or not
        // if not null
        // quit the browser
        // make it null , because once quit it can not be used
        if (obj != null) {
            obj.quit();
            // so when ask for it again , it gives us not quited fresh driver
            obj = null;
        }

    }

}

