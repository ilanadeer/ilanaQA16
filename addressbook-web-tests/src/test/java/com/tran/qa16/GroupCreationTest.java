package com.tran.qa16;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {


    @Test
    public void testGroupCreation() {
        goToGroupsPage();
        int before = getGroupsCount();

        initGroupCreation();

        fillGroupsForm(new GroupData()
                .withName("testGroupHeader1")
                .withHeader("testGroupHeader")
                .withFooter("testGroupFooter"));

        submitGroupCreation();

        returnToTheGroupsPage();
        int after = getGroupsCount();

        Assert.assertEquals(after,before+1);
    }

}
