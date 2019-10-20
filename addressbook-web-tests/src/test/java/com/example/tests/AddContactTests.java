package com.example.tests;

import com.example.models.ContactData;
import com.example.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class AddContactTests extends TestBase {

    @Test
    public void testAddContact() {
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("Anna", "Smith", "Test Address", "ann@mail.com", "895678567857");
        app.getContactHelper().createContact(contact);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size()+1);

        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
