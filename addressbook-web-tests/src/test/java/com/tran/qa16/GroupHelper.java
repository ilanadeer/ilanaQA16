package com.tran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase{
    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToTheGroupsPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupsForm(GroupData groupData) {
        type(By.name("group_name"));

        click(By.name("group_header"));
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys("testGroupHeader1");

        click(By.name("group_footer"));
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys("testGroupFooter1");
    }

    public void type(By locator) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys("testGroupName1");
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroup() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void updateGroupModification() {
        click(By.name("update"));
    }

    public void modifySelectedGroup() {
        click(By.name("group_name"));
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys("modifyedTestGroupName1");

        click(By.name("group_header"));
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys("modifyedTestGroupHeader1");

        click(By.name("group_footer"));
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys("modifyedTestGroupFooter1");
    }

    public void editGroup() {
        click(By.name("edit"));
    }

    public int getGroupsCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
    public void createGroup(){
        initGroupCreation();
        fillGroupsForm(new GroupData()
                .withName("testGroupName")
                .withHeader("testGroupHeader")
                .withFooter("testGroupFooter"));
        submitGroupCreation();
        returnToTheGroupsPage();
    }
    public boolean isGroupPresent(){
        return isElementPresent(By.name("selected[]"));
    }
    public void selectGroupByIndex(int ind) {
        wd.findElements(By.name("selected[]")).get(ind).click();
    }

}
