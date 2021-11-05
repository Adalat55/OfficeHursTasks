package com.cybertek.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    /**
     WebDriverFactory class:
     is used to create WebDriver(Selenium) object and return it.
     It will open the browser and maximize it
     method:
     getDriver(String browserType)
     It will check browser type and return object:
     if browserType is "chrome":
     it will set up chrome driver, and return new ChromeDriver
     if browserType is "firefox":
     it will set up firefox driver, and return new FirefoxDriver

     Ex:
     WebDriver driver= WebDriverFactory.getDriver("chrome");
     and use driver as normal
     */

    //static, so we can call this method without creating object

    public static WebDriver getDriver(String browserType){
        if (browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if(browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
            //new creates a new object

        }else {
            System.out.println("Invalid browser type"+ browserType);
            return null;
        }

    }
}
