package com.example.tests;

import com.example.models.ContactData;
import com.example.models.GroupData;
import org.testng.annotations.Test;


public class DeleteContactTests extends TestBase {

    @Test

    //Deletes a contact from the list of contacts (Home Page)
    public void deleteContactsTest() {
        app.getNavigationHelper().goToHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Anna", "Smith", "Test Address", "ann@mail.com", "895678567857"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContactFromList();
        app.getContactHelper().submitAlert();
    }
}
