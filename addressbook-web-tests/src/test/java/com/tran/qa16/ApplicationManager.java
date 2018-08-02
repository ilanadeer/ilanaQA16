package com.tran.qa16;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager{
    SessionHelper sessionHelper;
    GroupHelper groupHelper;
    private WebDriver wd;

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.openSite("http://localhost/addressbook");
        sessionHelper.login("admin", "secret");
        groupHelper = new GroupHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public void goToGroupsPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    public void goToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public void submitContactCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillContactForm(ContactData contactData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys("firstname");

        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys("lastname");

        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys("mobile");


        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys("email");
    }

    public void addNewContact() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void confirmAlert() {
        wd.switchTo().alert().accept();
    }

    public void deleteContact() {
        wd.findElement(By.xpath("//*[@value='Delete']")).click();
    }

    public void selectContact() {
        wd.findElement(By.name("selected[]")).click();

    }

    protected void dismissAlert() {
        wd.switchTo().alert().dismiss();
    }

    public boolean isElementPresent(By locator){
        try {
            wd.findElement(locator);
            return true;
        }catch (NoSuchElementException ex){
            System.out.println("This Element not located "+ex);
            return false;
        }
    }

    public boolean isElementsPresent(By locator){
        return wd.findElements(locator).size()>0;

    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
