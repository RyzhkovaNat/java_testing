package com.example.tests;

import com.example.models.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class EditContactTests extends TestBase {

    @Test

    //Changes contact data via the contact modification form
    public void editContactsTest() {
        app.goTo().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Anna", "Smith", "Test Address", "ann@mail.com", "895678567857"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().editContact(before.size() - 1);
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Sarah", "Craft", "Test", "lara@mail.com", "8888888888888");
        app.getContactHelper().enterFormData(contact);
        app.getContactHelper().submitUpdateForm();
        app.getContactHelper().ReturnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
