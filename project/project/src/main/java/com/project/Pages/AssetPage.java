package com.project.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssetPage extends BasePage{

    public AssetPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }
    private By asset = By.xpath("//*[@id=\"webui\"]/div/div[1]");
    // private By edit = By.xpath("/html/body/div[1]/div/section[2]/div[2]/div/div/div/div/div/div/div[1]/div[3]/div[2]/table/tbody/tr[1]/td[14]/nobr/a[2]");

    public void assetButton(){
WebElement element = driver.findElement(asset);
element.click();
  JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(" + 250  + ",0)", "");

    }
}
