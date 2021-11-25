package com.cybertek.officehours.oHO1;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class PolymerTest {
    /*
    Here is this week's task:
Write a basic browser automation framework to validate a Polymer website.
The focus should be on the interaction with the browser.
The Web Application under test http://todomvc.com/
    The first step should be to load the website,
    click within the JavaScript tab,
    and select the Polymer link.
    The second step should be: Add one Todo item
    Then Verify that the item added.
     */


    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        String url = "http://todomvc.com/";
        driver.manage().window().maximize();
        driver.get(url);



        WebElement tabLink= driver.findElement(By.xpath("//div[.='JavaScript']"));
        tabLink.click();


        WebElement addBox= driver.findElement(By.id("new-todo"));

        String toDoItemOne="Office Hours for 24";

        addBox.sendKeys(toDoItemOne+ Keys.ENTER);

        String locatorForAddedItem = "//label[.='"+toDoItemOne+"']";

        System.out.println(driver.findElement(By.xpath(locatorForAddedItem)).isDisplayed());


    }
}
