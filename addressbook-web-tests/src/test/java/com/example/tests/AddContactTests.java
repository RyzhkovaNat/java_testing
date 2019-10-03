package com.example.tests;

import com.example.models.ContactData;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @Test
    public void testAddContact() {
        app.getNavigationHelper().goToContactForm();
        app.getContactHelper().createContact(new ContactData("Anna", "Smith", "Test Address", "ann@mail.com", "895678567857"));
    }
}
