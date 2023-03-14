package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
 Instead of extending TestBase Class for Driver in POM
    Using static methods from the driver class
    creating a driver, making the relevant settings, and finally
    It is preferred to turn off the driver


    By creating an object of getDriver() in Driver class in POM
    The use of Singleton pattern is adopted to prevent its use.

    Singleton Patter; single use, object of a class from different classes
    It is used to prevent its use by creating

    What we need to do to achieve this is quite simple. creating an object
    When we make the constructor used for private, other classes
    It is not possible to create an object from the driver class



    */
    private Driver(){ //Private Constructor prevents object creation

    }
    static WebDriver driver;

    public static WebDriver getDriver(){

        if (driver==null){

            switch (ConfigReader.getProperty("browser")){
                case"chrome" :
                    ChromeOptions options=new ChromeOptions();
                    WebDriverManager.chromedriver().setup();
                    options.addArguments("--remote-allow-origins=*");
                    driver=new ChromeDriver(options);
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                default:WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
            }


            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().window().maximize();

        }


        return driver;
    }

    public static void closeDriver(){

        if (driver!=null){
            driver.close();
            driver=null;
        }



    }
}
