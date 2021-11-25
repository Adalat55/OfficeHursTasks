package com.cybertek.officehours.oHO1;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PolymerTaskForPractice {

   public static WebDriver driver;

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        String url = "http://todomvc.com/";
        driver.get(url);
        driver.manage().window().maximize();
//        WebElement tabLink= driver.findElement(By.xpath("//div[.='JavaScript']"));
//        tabLink.click();

        getTab("JavaScript").click();

        getLink("Polymer").click();
//        WebElement link = driver.findElement(By.linkText("Dijon"));
//        link.click();

        WebElement addBox = driver.findElement(By.xpath("//[@placeholder='What needs to be done?']"));

        String toDoItem= "we will see";

        addBox.sendKeys(toDoItem+Keys.ENTER);

        String addedItemLocator= "//label[.='"+toDoItem+"']";

        System.out.println("driver.findElement(By.xpath(addedItemLocator)).isDisplayed() = " + driver.findElement(By.xpath(addedItemLocator)).isDisplayed());


    }

    public static WebElement getTab(String tab){
       // String locator = "//div[.='"+tab+"']";

        return driver.findElement(By.linkText(tab));
    }

    public static WebElement getLink(String link){
        return driver.findElement(By.linkText(link));
    }


}
