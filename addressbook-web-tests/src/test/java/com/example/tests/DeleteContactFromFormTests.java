package com.example.tests;

import com.example.models.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DeleteContactFromFormTests extends TestBase {

    @Test

    //Deletes a contact via the contact modification form
    public void editContactsTest() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Anna", "Smith", "Test Address", "ann@mail.com", "895678567857"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().editContact(before.size() - 1);
        app.getContactHelper().deleteContactFromForm();
        app.getNavigationHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
