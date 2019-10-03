package com.example.tests;

import com.example.models.ContactData;
import org.testng.annotations.Test;

public class EditContactModificationTests extends TestBase {

    @Test

    //Changes contact data via the contact modification form
    public void editContactsTest() {
        app.getNavigationHelper().goToHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().goToContactForm();
            app.getContactHelper().createContact(new ContactData("Anna", "Smith", "Test Address", "ann@mail.com", "895678567857"));
        }
        app.getContactHelper().editContact();
        app.getContactHelper().enterFormData(new ContactData("Sarah", "Craft", "Test", "lara@mail.com", "8888888888888"));
        app.getContactHelper().submitUpdateForm();
        app.getContactHelper().ReturnToHomePage();
    }
}
