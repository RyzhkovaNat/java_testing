package com.example.tests;

import org.testng.annotations.Test;


public class DeleteContactTests extends TestBase {
    @Test

    public void deleteContactsTest() throws Exception {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContactFromList();
        app.getContactHelper().submitAlert();
    }

}
