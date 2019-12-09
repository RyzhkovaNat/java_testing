package com.example.tests;

import com.example.models.ContactData;
import com.example.models.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class EditContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.db().contacts().size()==0) {
            app.contact().create(new ContactData().withFirstName("Anna").withLastName("Smith").withAddress("Test Address").withEmail("ann@mail.com").withWorkPhone("833333333332395").withMobilePhone("8438394927383").withHomePhone("83029474202"));
        }
    }

    @Test

    //Changes contact data via the contact modification form
    public void editContactsTest() {
        Contacts before = app.db().contacts();
        ContactData editedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(editedContact.getId()).withFirstName("Lana").withLastName("Stales").withAddress("Test Address2").withEmail("lana@mail.com").withWorkPhone("1").withMobilePhone("2").withHomePhone("3");
        app.contact().edit(contact);
        Contacts after = app.db().contacts();
        assertThat(after.size(),  equalTo(before.size()));
        assertThat(after, equalTo(before.without(editedContact).withAdded(contact)));
    }
}
