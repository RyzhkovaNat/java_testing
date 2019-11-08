package com.example.tests;

import com.example.models.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class AddContactTests extends TestBase {

    @Test
    public void testAddContact() {
        List<ContactData> before = app.contact().getContactList();
        ContactData contact =
                new ContactData().withFirstName("Anna").withLastName("Smith").withAddress("Test Address").withEmail("ann@mail.com").withPhone("895678567857");
        app.contact().create(contact);
        List<ContactData> after = app.contact().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
