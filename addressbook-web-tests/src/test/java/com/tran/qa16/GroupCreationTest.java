package com.tran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {


    @Test
    public void testGroupCreation() {
        app.goToGroupsPage();
        int before = app.getGroupHelper().getGroupsCount();

        app.getGroupHelper().initGroupCreation();

        app.getGroupHelper().fillGroupsForm(new GroupData()
                .withName("testGroupHeader1")
                .withHeader("testGroupHeader")
                .withFooter("testGroupFooter"));

        app.getGroupHelper().submitGroupCreation();

        app.getGroupHelper().returnToTheGroupsPage();
        int after = app.getGroupHelper().getGroupsCount();

        Assert.assertEquals(after,before+1);
    }

}
