package com.example.tests;

import org.testng.annotations.Test;


public class DeleteContactTests extends TestBase {

    @Test

    //Deletes a contact from the list of contacts (Home Page)
    public void deleteContactsTest() {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContactFromList();
        app.getContactHelper().submitAlert();
    }
}
