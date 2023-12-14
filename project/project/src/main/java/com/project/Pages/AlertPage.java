package com.project.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }
    ///html/body/div[1]/header/nav/div[2]/ul/li[8]/a
private By alert = By.xpath("/html/body/div[1]/header/nav/div[2]/ul/li[8]/a");
private By CardStock = By.xpath("/html/body/div[1]/header/nav/div[2]/ul/li[8]/ul/li[2]/ul/li[1]/a");
public void alertMethod(){
    //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    // WebElement alerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(alert));
 WebElement alerElement = driver.findElement(alert);
alerElement.click();
 WebElement CardStockElement = driver.findElement(CardStock);
 CardStockElement.click();
}
}
