package com.tran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{
    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String userName, String password) {
        click(By.name("user"));
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(userName);

        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);

        wd.findElement(By.xpath("//*[@value='Login']")).click();
    }

    public void openSite(String url) {

        wd.get(url);
    }
}
