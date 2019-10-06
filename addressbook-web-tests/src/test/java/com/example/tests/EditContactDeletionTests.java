package com.example.tests;

import com.example.models.ContactData;
import org.testng.annotations.Test;

public class EditContactDeletionTests extends TestBase {

    @Test

    //Deletes a contact via the contact modification form
    public void editContactsTest() {
        app.getNavigationHelper().goToHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Anna", "Smith", "Test Address", "ann@mail.com", "895678567857"));
        }
        app.getContactHelper().editContact();
        app.getContactHelper().deleteContactFromForm();
    }
}
