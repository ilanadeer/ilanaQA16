package com.tran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.NoSuchElementException;

public class HelperBase {
    public WebDriver wd;

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public boolean isElementPresent(By locator){
        try {
            wd.findElement(locator);
            return true;
        }catch (NoSuchElementException ex){
            System.out.println("This Element not located "+ex);
            return false;
        }
    }
}
