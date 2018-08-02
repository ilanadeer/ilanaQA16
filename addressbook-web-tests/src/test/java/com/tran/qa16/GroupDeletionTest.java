package com.tran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.NoSuchElementException;

public class GroupDeletionTest extends TestBase {

    @Test
    public void testLastGroupDeletion() {
        app.goToGroupsPage();

        if(!app.getGroupHelper().isGroupPresent()){
            app.getGroupHelper().createGroup();
        }
        int before = app.getGroupHelper().getGroupsCount();
        app.selectGroupByIndex(before-1);//lastgroup
        app.getGroupHelper().deleteSelectedGroup();
        app.getGroupHelper().returnToTheGroupsPage();
        int after = app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after, before-1);
    }
    @Test
    public void testFirstGroupDeletion() {
        app.goToGroupsPage();

        if(!app.getGroupHelper().isGroupPresent()){
            app.getGroupHelper().createGroup();
        }
        int before = app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().selectGroup();//fistgroup
        app.getGroupHelper().deleteSelectedGroup();
        app.getGroupHelper().returnToTheGroupsPage();
        int after = app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after, before-1);
    }


}
