package com.tran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase{

    @Test
    public void ContactDeletionTest() {
        int before = app.getGroupHelper().getGroupsCount();
        app.selectContact();
        app.deleteContact();
        app.confirmAlert();
        app.dismissAlert();
        int after = app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after, before-1);
    }
}
