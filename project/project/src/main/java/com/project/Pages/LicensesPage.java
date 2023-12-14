 package com.project.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LicensesPage extends BasePage {

    public LicensesPage(WebDriver driver) {
        super(driver);
        
    }

  
    private By licenses = By.xpath("/html/body/div[1]/aside/section/ul/li[3]/a");

    // public void reportButton() {
    //     WebElement reportElement = driver.findElement(report);
    //     reportElement.click();
    //      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      
    //      WebElement selectedOption =driver.findElement(By.xpath("/html/body/div[1]/aside/section/ul/li[11]/ul/li[2]/a"));
        
    //     selectedOption.click();
    // }
    public void licensesButton() {
    WebElement licensesElement = driver.findElement(licenses);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", licensesElement);
    licensesElement.click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 
//    WebElement selectedOption = driver.findElement(By.xpath("/html/body/div[1]/aside/section/ul/li[11]/ul/li[2]/a"));

    // wait.until(ExpectedConditions.elementToBeClickable(selectedOption));
    // selectedOption.click();
}

}