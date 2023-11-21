// File: src/main/java/browserfactory/BaseTest.java
package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;

    public void setup() {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of the Chrome driver
        driver = new ChromeDriver();
    }

    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
