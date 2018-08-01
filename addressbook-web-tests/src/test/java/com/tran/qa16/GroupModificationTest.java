package com.tran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification() {
        app.goToGroupsPage();
        int before = app.getGroupHelper().getGroupsCount();

        app.getGroupHelper().selectGroup();

        app.getGroupHelper().editGroup();

        app.getGroupHelper().fillGroupsForm(new GroupData()
                .withName("1")
                .withHeader("2")
                .withFooter("3"));

        app.getGroupHelper().updateGroupModification();

        app.getGroupHelper().returnToTheGroupsPage();
        int after = app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after, before+1);

    }

}
