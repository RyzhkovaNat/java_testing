package com.example.tests;

import com.example.models.ContactData;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @Test
    public void testAddContact() throws Exception {
        app.getNavigationHelper().goToContactForm();
        app.getContactHelper().enterFormData(new ContactData("Anna", "Smith", "Test Address", "ann@mail.com", "895678567857"));
        app.getContactHelper().submitContactForm();
        app.getContactHelper().ReturnToHomePage();
    }
}
