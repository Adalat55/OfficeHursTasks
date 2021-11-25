package com.cybertek.officehours.oHO2;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTask {

    /*
    Test Case 1:
    Basic login authentication
    -Go to : http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    -Verify title equals: String expectedTitle= "Web Orders Login"
    -Enter username : Tester
    -Enter password: test
    -Click "Sign in" button
    -Verify title equals: String expectedHomePageTitle= "Web Orders"

    Test Case 2:
    After login
    -click on Check All button
    -verify that all check buttons are selected
    -click on Uncheck All button
    -verify that all buttons are unchecked
    -select one of the check box and delete that row
    -verify that row of information is deleted

     */

   String url = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";

   WebDriver driver;

   @BeforeClass
   public void setUp(){

    driver= WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.get(url);

}


   @Test
   public void testTitle(){

      String expectedTitleBeforeLogin= "Web Orders Login";
      String actualTitle= driver.getTitle();
      Assert.assertEquals(driver.getTitle(), expectedTitleBeforeLogin);

       WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
       username.sendKeys("Tester");
       WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
       password.sendKeys("test"+ Keys.ENTER);

       Assert.assertEquals(driver.getTitle(),"Web Orders");

   }

   @Test
   public void checkBoxTest(){
       driver= WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       driver.get(url);
       WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
       username.sendKeys("Tester");
       WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
       password.sendKeys("test"+ Keys.ENTER);

    WebElement checkAll= driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));
    checkAll.click();


    List<WebElement> checkButtons = driver.findElements(By.xpath("//input[@type='checkbox']"));

    int counter=0;

       for (WebElement checkButton : checkButtons) {

           if(checkButton.isSelected()){
               counter++;
           }


       }
       if(counter==checkButtons.size()){
           System.out.println("all selected");
       }else{
           System.out.println("not selected");
       }


       WebElement uncheckAllButton = driver.findElement(By.id("ctl00_MainContent_btnUncheckAll"));
       uncheckAllButton.click();

       checkButtons = driver.findElements(By.xpath("//input[@type='checkbox']"));
       for (WebElement eachCheckButton : checkButtons) {

           if(eachCheckButton.isSelected()){
               System.out.println("not unckeched");
           }
       }


       WebElement itemForDeleted = driver.findElement(By.xpath("//tr//td[.='Susan McLaren']/..//input"));
       itemForDeleted.click();
       WebElement deleteButton = driver.findElement(By.name("ctl00$MainContent$btnDelete"));
       deleteButton.click();
       checkButtons = driver.findElements(By.xpath("//input[@type='checkbox']"));
       System.out.println(checkButtons.size());
   }












   public void tearDown(){
       driver.quit();
   }






}
