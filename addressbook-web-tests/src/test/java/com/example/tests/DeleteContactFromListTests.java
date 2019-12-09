package com.example.tests;

import com.example.models.ContactData;
import com.example.models.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class DeleteContactFromListTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.db().contacts().size()==0) {
            app.contact().create(new ContactData().withFirstName("Anna").withLastName("Smith").withAddress("Test Address").withEmail("ann@mail.com").withWorkPhone("833333333332395").withMobilePhone("8438394927383").withHomePhone("83029474202"));
        }
    }

    @Test

    //Deletes a contact from the list of contacts (Home Page)
    public void deleteContactsTest() {
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().deleteFromList(deletedContact);
        Contacts after = app.db().contacts();
        assertThat(after.size(), equalTo(before.size() - 1));
        assertThat(after, equalTo(before.without(deletedContact)));
    }

}
