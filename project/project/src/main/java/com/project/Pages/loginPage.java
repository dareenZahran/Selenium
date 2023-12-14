package com.project.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage extends BasePage {

    public loginPage(WebDriver driver) {
        super(driver);
    }

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("/html/body/form/div/div/div/div/div[3]/button");

    // Methods to interact with the elements
    public void enterUsername(String username) {
        WebElement usernameElement = driver.findElement(usernameField);
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = driver.findElement(loginButton);
        loginButtonElement.click();

    }

    // Complete login action
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    // Method to navigate to the Create Asset page
    public CreateAssetPage navigateToCreateAssetPage() {
        WebElement dropdownToggle = driver.findElement(By.xpath("/html/body/div[1]/header/nav/div[2]/ul/li[7]"));

        dropdownToggle.click();

        // Wait for the dropdown options to appear and click an option
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement optionToSelect = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("/html/body/div[1]/header/nav/div[2]/ul/li[7]/ul/li[1]/a")));
        optionToSelect.click();

        return new CreateAssetPage(driver);

    }
}
