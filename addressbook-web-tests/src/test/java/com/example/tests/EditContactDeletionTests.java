package com.example.tests;

import com.example.models.ContactData;
import org.testng.annotations.Test;

public class EditContactDeletionTests extends TestBase {

    @Test
    public void editContactsTest() throws Exception {
       app.getNavigationHelper().goToHomePage();
       app.getContactHelper().editContact();
       app.getContactHelper().deleteContactFromForm();
       app.getNavigationHelper().goToHomePageAfterOperation();
    }
}
