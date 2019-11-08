package com.example.tests;

import com.example.models.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class EditContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().getContactList().size() == 0) {
            app.contact().create(new ContactData().withFirstName("Anna").withLastName("Smith").withAddress("Test Address").withEmail("ann@mail.com").withPhone("895678567857"));
        }
    }

    @Test

    //Changes contact data via the contact modification form
    public void editContactsTest() {
        List<ContactData> before = app.contact().getContactList();
        int index = before.size() - 1;
        ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstName("Lana").withLastName("Stales").withAddress("Test Address2").withEmail("lana@mail.com").withPhone("895344332234");
        app.contact().edit(index, contact);
        List<ContactData> after = app.contact().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
