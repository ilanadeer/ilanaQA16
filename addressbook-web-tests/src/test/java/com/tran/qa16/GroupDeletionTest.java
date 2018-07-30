package com.tran.qa16;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

    @Test
    public void testLastGroupDeletion() {
        goToGroupsPage();

        if(!isGroupPresent()){
            createGroup();
        }
        int before = getGroupsCount();
        selectGroupByIndex(before-1);//lastgroup
        deleteSelectedGroup();
        returnToTheGroupsPage();
        int after = getGroupsCount();
        Assert.assertEquals(after, before-1);
    }
    @Test
    public void testFirstGroupDeletion() {
        goToGroupsPage();

        if(!isGroupPresent()){
            createGroup();
        }
        int before = getGroupsCount();
        selectGroup();//fistgroup
        deleteSelectedGroup();
        returnToTheGroupsPage();
        int after = getGroupsCount();
        Assert.assertEquals(after, before-1);
    }


}
