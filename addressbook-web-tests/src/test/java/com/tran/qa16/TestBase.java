package com.tran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        start();
        openSite();
        login();
    }

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    public void login() {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("admin");

        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys("secret");

        wd.findElement(By.xpath("//*[@value='Login']")).click();
    }

    public void openSite() {
        wd.get("http://localhost/addressbook");
    }

    public void returnToTheGroupsPage() {
        wd.findElement(By.linkText("group page")).click();
    }

    public void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillGroupsForm(GroupData groupData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys("testGroupName1");

        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys("testGroupHeader1");

        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys("testGroupFooter1");
    }

    public void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    public void goToGroupsPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    public void deleteSelectedGroup() {
        wd.findElement(By.name("delete")).click();
    }

    public void selectGroup() {
        wd.findElement(By.name("selected[]")).click();
    }

    public void updateGroupModification() {
        wd.findElement(By.name("update")).click();
    }

    public void modifySelectedGroup() {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys("modifyedTestGroupName1");

        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys("modifyedTestGroupHeader1");

        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys("modifyedTestGroupFooter1");
    }

    public void editGroup() {
        wd.findElement(By.name("edit")).click();
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

    public int getGroupsCount() {
        return wd.findElements(By.name("selected[]")).size();
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


    public void selectGroupByIndex(int ind) {
        wd.findElements(By.name("selected[]")).get(ind).click();
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

    public boolean isGroupPresent(){
        return isElementPresent(By.name("selected[]"));
    }

    public void createGroup(){
        initGroupCreation();
        fillGroupsForm(new GroupData()
                .withName("testGroupHeader1")
                .withHeader("testGroupHeader")
                .withFooter("testGroupFooter"));
        submitGroupCreation();
        returnToTheGroupsPage();
    }
    public boolean isElementsPresent(By locator){
        return wd.findElements(locator).size()>0;

    }

}
