package com.example.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.project.Pages.AlertPage;
import com.project.Pages.AssetPage;
import com.project.Pages.CreateAssetPage;

import com.project.Pages.LicensesPage;
import com.project.Pages.LogoutPage;
import com.project.Pages.Search;
import com.project.Pages.loginPage;
import com.project.utils.BrowserType;
import com.project.utils.BrowserTypeConverter;
import com.project.utils.WebDrivers;



@Execution(ExecutionMode.CONCURRENT)

public class CrossBrowserParallelTest {




    @ParameterizedTest
    // @EnumSource(BrowserType.class)
    @CsvFileSource(resources = "/Signin.csv", numLinesToSkip = 1)
    public void testLoginAndCreateAsset(@ConvertWith(BrowserTypeConverter.class) BrowserType browserType,String username, String password, int companyIndex,String tag, int modelIndex, int statusIndex) {
        // String username = "admin";
        // String password = "password";
        // int companyIndex=3;
        // int modelIndex=3;
        // int statusIndex=3;


        WebDriver driver = WebDrivers.createInstance(browserType);
// WebDriver driver = new ChromeDriver();


        try {
            driver.get("https://demo.snipeitapp.com/");

            loginPage loginPage = new loginPage(driver);

            loginPage.login(username, password);
assertEquals("Dashboard", driver.findElement(By.xpath("//*[@id=\"setting-list\"]/section[1]/h1")).getText());
            CreateAssetPage createAssetPage = loginPage.navigateToCreateAssetPage();

            createAssetPage.createNewAsset(companyIndex,tag,modelIndex,statusIndex);

assertEquals("DEMO MODE: Some features are disabled for this installation.", driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[1]/div")).getText());


        } 
        finally {
            // if (driver != null) {
            //     driver.quit();
            // }
        }
    }
  @ParameterizedTest
 @EnumSource(BrowserType.class)
public void wrongsign(BrowserType browserType){
 WebDriver driver = WebDrivers.createInstance(browserType);

        try {
            driver.get("https://demo.snipeitapp.com/");

            loginPage loginPage = new loginPage(driver);
try {
       loginPage.login("urname", "password"); 
} catch (Exception e) {
    System.out.println("errorpage");
}
        
          
          
            String errorM = driver.findElement(By.xpath("/html/body/form/div/div/div/div/div[2]/div/div[2]/div/strong")).getText();
             assertEquals("Error:", errorM);
            // System.out.println(errorM);
        } 
        finally {
            // if (driver != null) {
            //     driver.quit();
            // }
        }

}
@ParameterizedTest
 @EnumSource(BrowserType.class)
public void logout(BrowserType browserType){
// /html/body/form/div/div/div/div/div[2]/div/div[2]/div/strong
WebDriver driver = WebDrivers.createInstance(browserType);
 driver.get("https://demo.snipeitapp.com/");
 loginPage login = new loginPage(driver);
 login.login("admin","password" );
 LogoutPage logout = new LogoutPage(driver);
 logout.dropUserAdmain();


}

@ParameterizedTest
 @EnumSource(BrowserType.class)
public void SearchTest (BrowserType browserType){
WebDriver driver = WebDrivers.createInstance(browserType);
 driver.get("https://demo.snipeitapp.com/");
 loginPage login = new loginPage(driver);
 login.login("admin","password" );
Search search = new Search(driver);
search.searchMethod();
String actual = driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div[1]/div[1]/div")).getText();
assertEquals("DEMO MODE: Some features are disabled for this installation.",actual);
}



@ParameterizedTest
 @EnumSource(BrowserType.class)
 public void LicensesTest(BrowserType browserType){

WebDriver driver = WebDrivers.createInstance(browserType);
 driver.get("https://demo.snipeitapp.com/");
 loginPage login = new loginPage(driver);
 login.login("admin","password" );

LicensesPage license = new LicensesPage(driver);

license.licensesButton();
 String expectedUrl = "https://demo.snipeitapp.com/licenses";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);



 }

@ParameterizedTest
 @EnumSource(BrowserType.class)
 public void AssetTest( BrowserType browserType){
WebDriver driver = WebDrivers.createInstance(browserType);
 driver.get("https://demo.snipeitapp.com/");
 loginPage login = new loginPage(driver);
 login.login("admin","password" );
 AssetPage asset=new AssetPage(driver);
 asset.assetButton();
 String expectedUrl = "https://demo.snipeitapp.com/hardware";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
 }

@ParameterizedTest
 @EnumSource(BrowserType.class)
 public void AlertTest( BrowserType browserType){
WebDriver driver = WebDrivers.createInstance(browserType);
 driver.get("https://demo.snipeitapp.com/");
 loginPage login = new loginPage(driver);
 login.login("admin","password" );
 driver.get("https://demo.snipeitapp.com/");
 AlertPage alert = new AlertPage(driver);
 alert.alertMethod();
 //https://demo.snipeitapp.com/consumables/1
  String expectedUrl = "https://demo.snipeitapp.com/consumables/1";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
 }
   }
