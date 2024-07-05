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
    public void the_user_navigates_to_the_saucedemo_login_page() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1366,768");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
    }

    @When("The user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("The user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("The user should see the products page with title {string}")
    public void the_user_should_see_the_products_page_with_title(String expectedTitle) {
        String actualTitle = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.quit();
    }

    @Then("The user should see the error message {string}")
    public void the_user_should_see_the_error_message(String expectedErrorMessage) {
        String actualErrorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
        driver.quit();
    }
}


