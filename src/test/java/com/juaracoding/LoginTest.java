package com.juaracoding;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;

public class LoginTest {
    WebDriver driver;

    @Given("The user navigates to the SauceDemo login page")
    public void theUserNavigatesToTheSauceDemoLoginPage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1366,768");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
    }

    @When("The user enters username {string} and password {string}")
    public void theUserEntersUsernameAndPassword(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("The user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("The user should see the products page with title {string}")
    public void theUserShouldSeeTheProductsPageWithTitle(String expectedTitle) {
        String actualTitle = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.quit();
    }

    @Then("The user should see the error message {string}")
    public void theUserShouldSeeTheErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
        driver.quit();
    }
}


