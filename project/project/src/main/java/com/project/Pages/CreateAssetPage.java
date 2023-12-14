package com.project.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAssetPage extends BasePage {

    public CreateAssetPage(WebDriver driver) {
        super(driver);
    }

    public void createNewAsset(int companyIndex, String tag,int modelIndex, int statusIndex) {
   
        selectCompany(companyIndex);
        AssetTag(tag);
        selectModel(modelIndex);
        selectStatus(statusIndex);
        save();
    }

 

    public void selectCompany(int index) {
        WebElement companyDropdown = driver.findElement(By.xpath("//*[@id='select2-company_select-container']"));
        companyDropdown.click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String companyOptionXPath = "//*[@id='select2-company_select-results']/li[" + index + "]/div/div[2]";
        WebElement companyOption = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(companyOptionXPath)));
        companyOption.click();
   
    }
  public void AssetTag(String tag) {
        WebElement assetTag = driver.findElement(By.id("asset_tag"));
        assetTag.sendKeys(tag);;
   
   
    }
 

    public void selectModel(int index) {
        WebElement modelDropdown = driver.findElement(By.xpath("//*[@id='select2-model_select_id-container']"));
        modelDropdown.click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String modelOptionXPath = "//*[@id='select2-model_select_id-results']/li[" + index + "]/div/div[2]";
        WebElement modelOption =wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(modelOptionXPath)));
        modelOption.click();
    }

    public void selectStatus(int index) {
        WebElement statusDropdown = driver
                .findElement(By.xpath("//*[@id='create-form']/div/div[2]/div/div[6]/div[1]/span/span[1]/span"));
        statusDropdown.click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String statusXPath = "//*[@id='select2-status_select_id-results']/li[" + index + "]";
        WebElement statusOption =wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(statusXPath)));
        statusOption.click();
    }

    public void save(){
          WebElement save = driver
                .findElement(By.xpath("//*[@id=\"create-form\"]/div/div[2]/div/div[18]/button"));
        save.click();
    }
}
