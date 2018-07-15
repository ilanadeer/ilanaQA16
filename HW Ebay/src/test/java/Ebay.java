package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;


public class Ebay {
  private WebDriver driver;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEbay() {
    openSite();
    driver.findElement(By.linkText("register")).click();

    fillFirstname();

    fillLastname();

    fillEmail();

    fillPassword();
  }

  public void fillPassword() {
    driver.findElement(By.id("PASSWORD")).click();
    driver.findElement(By.id("PASSWORD")).clear();
    driver.findElement(By.id("PASSWORD")).sendKeys("31052013q");
  }

  public void fillEmail() {
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("ilana_6@mail.ru");
  }

  public void fillLastname() {
    driver.findElement(By.id("lastname")).click();
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("pudovik");
  }

  public void fillFirstname() {
    driver.findElement(By.id("firstname")).click();
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("ilana");
  }

  public void openSite() {
    driver.get("https://www.ebay.com/");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() {
    driver.quit();
  }

  private boolean isElementPresent(By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
