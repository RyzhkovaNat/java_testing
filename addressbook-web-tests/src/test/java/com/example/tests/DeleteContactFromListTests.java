package com.example.tests;

import com.example.models.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class DeleteContactFromListTests extends TestBase {

    @Test

    //Deletes a contact from the list of contacts (Home Page)
    public void deleteContactsTest() {
        app.goTo().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Anna", "Smith", "Test Address", "ann@mail.com", "895678567857"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteContactFromList();
        app.getContactHelper().submitAlert();
        app.goTo().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
