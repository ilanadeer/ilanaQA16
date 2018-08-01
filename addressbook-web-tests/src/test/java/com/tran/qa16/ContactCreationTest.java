package com.tran.qa16;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {
    @Test
    public void testContactCreation() {
        app.addNewContact();

        app.fillContactForm(new ContactData("Anna", "Ivanova", "052000", "qwerty@mail.com"));

        app.submitContactCreation();

        app.goToHomePage();
    }
}
