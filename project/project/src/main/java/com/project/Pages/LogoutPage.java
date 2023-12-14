 package com.project.Pages;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LogoutPage extends BasePage {

    public LogoutPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }
  private By userAdmain = By.xpath("/html/body/div[1]/header/nav/div[2]/ul/li[9]/a");
  
  
public void dropUserAdmain() {
        WebElement dropdown = driver.findElement(userAdmain);
        dropdown.click();
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      
       
    // Select select2=new Select(driver.findElement(By.xpath("/html/body/div[1]/header/nav/div[2]/ul/li[9]/ul/li[8]/a"))) ;
      
         WebElement selectedOption =driver.findElement(By.xpath("/html/body/div[1]/header/nav/div[2]/ul/li[9]/ul/li[8]/a"));
        selectedOption.click();
    }
}