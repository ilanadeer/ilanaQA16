package com.tran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

    @Test
    public void testGroupModification() {
        goToGroupsPage();
        int before = getGroupsCount();

        selectGroup();

        deleteSelectedGroup();

        returnToTheGroupsPage();
        int after = getGroupsCount();
        Assert.assertEquals(before, after-1);

    }
}
