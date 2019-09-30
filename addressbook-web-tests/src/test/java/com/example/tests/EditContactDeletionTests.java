package com.example.tests;

import org.testng.annotations.Test;

public class EditContactDeletionTests extends TestBase {

    @Test

    //Deletes a contact via the contact modification form
    public void editContactsTest() throws Exception {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().editContact();
        app.getContactHelper().deleteContactFromForm();
    }
}
