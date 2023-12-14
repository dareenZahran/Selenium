package com.project.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search extends BasePage{
    public Search(WebDriver driver) {
        super(driver);
      
    }
    //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 private By search = By.id("tagSearch");
//    private By searchicon = By.xpath("/html/body/div[1]/header/nav/div[2]/ul/li[6]/form/div/div[2]/button");

 public void searchMethod(){
 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement searchElement = wait.until(ExpectedConditions.visibilityOfElementLocated(search));

    searchElement.click(); 
    searchElement.sendKeys("Laptop");
    searchElement.submit();

 }
   
}
