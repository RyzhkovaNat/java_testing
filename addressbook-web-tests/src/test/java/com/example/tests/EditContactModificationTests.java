package com.example.tests;

import com.example.models.ContactData;
import org.testng.annotations.Test;

public class EditContactModificationTests extends TestBase {

    @Test
    public void editContactsTest() throws Exception {
       app.getNavigationHelper().goToHomePage();
       app.getContactHelper().editContact();
       app.getContactHelper().enterFormData(new ContactData("Sarah", "Craft", "Test", "lara@mail.com", "8888888888888"));
       app.getContactHelper().submitUpdateForm();
       app.getNavigationHelper().goToHomePageAfterOperation();
    }
}
