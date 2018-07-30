package com.tran.qa16;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase{

    @Test
    public void ContactDeletionTest() {
        int before = getGroupsCount();
        selectContact();
        deleteContact();
        confirmAlert();
        dismissAlert();
        int after = getGroupsCount();
        Assert.assertEquals(after, before-1);
    }
}
