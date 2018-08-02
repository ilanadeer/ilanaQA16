package com.tran.qa16;

import org.testng.annotations.*;

public class TestBase extends ApplicationManager{

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp() {
        app.start();

    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }


}
