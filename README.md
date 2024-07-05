# Data Driven Testing using Cucumber Scenario Outline

## Overview

This is a Java project that utilizes JDK 17, Selenium, Cucumber Scenario Outline, and TestNG. The project is designed to automate browser testing using Selenium WebDriver, defining test scenarios in Gherkin language with Cucumber, and running the tests with TestNG.

## Features

- **Java JDK 17**: Leveraging the latest features of Java.
- **Selenium WebDriver**: Automating browser actions for testing.
- **Cucumber**: Writing test cases in a behavior-driven development (BDD) style.
- **Scenario Outline**: Reusing test steps with multiple sets of data.
- **TestNG**: Organizing and executing test runs efficiently.

## Prerequisites

- [Java JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- A preferred IDE ([IntelliJ IDEA](https://www.jetbrains.com/idea/), [Eclipse](https://www.eclipse.org/downloads/), etc.)

## Setup

1. **Clone the repository**

    ```bash
    git clone https://github.com/koswara-dev/cucumber-scenario-outline.git
    cd cucumber-scenario-outline
    ```

2. **Install dependencies**

   Ensure you have Maven installed and run:

    ```bash
    mvn clean install
    ```

3. **Configure WebDriver**

    - Download the appropriate WebDriver for your browser (e.g., ChromeDriver for Google Chrome).
    - Set the path to the WebDriver executable in your system's PATH environment variable or configure it within your project setup.

## Running Tests

### Using Maven

```bash
mvn test
```

### Using TestNG XML Suite

Open and run the `testng.xml` file located in the root directory of the project from your IDE.

## Project Structure

    ├── src
    │   ├── main
    │   │   └── java
    │   └── test
    │       ├── java
    │       │   ├── stepdefinitions
    │       │   ├── runners
    │       │   └── utils
    │       └── resources
    │           └── features
    ├── pom.xml
    └── README.md

- **stepdefinitions**: Contains Cucumber step definition classes.
- **runners**: Contains TestNG runner classes.
- **utils**: Utility classes and methods.
- **features**: Feature files written in Gherkin language.

## Example

### Feature File (`src/test/resources/features/example.feature`)

```gherkin
Feature: Example feature

  Scenario Outline: Testing with valid credentials
    Given I navigate to the login page
    When I enter "<username>" and "<password>"
    Then I should see the home page

    Examples:
      | username | password |
      | user1    | pass1    |
      | user2    | pass2    |
```

### Step Definitions (`src/test/java/stepdefinitions/ExampleSteps.java`)

```java
package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ExampleSteps {
    WebDriver driver;

    @Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        driver = new ChromeDriver();
        driver.get("http://example.com/login");
    }

    @When("I enter {string} and {string}")
    public void iEnterUsernameAndPassword(String username, String password) {
        // Code to input username and password
    }

    @Then("I should see the home page")
    public void iShouldSeeTheHomePage(){
        // Code to validate home page
    }
}
```

### Test Runner (`src/test/java/runners/TestRunner.java`)

```java
package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
```

## Buy me a coffe

If you like this project and want to support its further development, buy me a coffee!

[![Buy Me a Coffee](https://www.buymeacoffee.com/assets/img/guidelines/download-assets-sm-1.svg)](https://www.buymeacoffee.com/kudajengke404)