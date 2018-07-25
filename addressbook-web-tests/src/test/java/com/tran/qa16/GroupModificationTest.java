package com.tran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification() {
        goToGroupsPage();
        int before = getGroupsCount();

        selectGroup();

        editGroup();

        fillGroupsForm(new GroupData()
                .withName("1")
                .withHeader("2")
                .withFooter("3"));

        updateGroupModification();

        returnToTheGroupsPage();
        int after = getGroupsCount();
        Assert.assertEquals(after, before+1);

    }

}
