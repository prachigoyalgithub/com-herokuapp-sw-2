// File: src/test/java/testsuite/LoginTest.java
package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private static final String BASE_URL = "http://the-internet.herokuapp.com/login";

    @Before
    public void beforeTest() {
        // Setup the WebDriver before each test
        setup();
    }

    @After
    public void afterTest() {
        // Tear down the WebDriver after each test
        tearDown();
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Navigate to the base URL
        driver.get(BASE_URL);

        // Enter "tomsmith" username
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("tomsmith");

        // Enter "SuperSecretPassword!" password
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("SuperSecretPassword!");

        // Click on 'LOGIN' button
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        // Verify the text "Secure Area"
        WebElement secureAreaText = driver.findElement(By.xpath("//h4[contains(text(), 'Secure Area')]"));
        assertTrue("Secure Area text is not displayed", secureAreaText.isDisplayed());
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        // Navigate to the base URL
        driver.get(BASE_URL);

        // Enter "tomsmith1" username
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("tomsmith1");

        // Enter "SuperSecretPassword!" password
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("SuperSecretPassword!");

        // Click on 'LOGIN' button
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        // Verify the error message "Your username is invalid!"
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='flash']/div[contains(text(), 'Your username is invalid!')]"));
        assertTrue("Username error message is not displayed", errorMessage.isDisplayed());
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        // Navigate to the base URL
        driver.get(BASE_URL);

        // Enter "tomsmith" username
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("tomsmith");

        // Enter "SuperSecretPassword" password
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("SuperSecretPassword");

        // Click on 'LOGIN' button
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        // Verify the error message "Your password is invalid!"
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='flash']/div[contains(text(), 'Your password is invalid!')]"));
        assertTrue("Password error message is not displayed", errorMessage.isDisplayed());
    }
}
