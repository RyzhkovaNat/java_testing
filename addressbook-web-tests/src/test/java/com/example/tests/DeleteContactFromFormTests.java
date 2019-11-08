package com.example.tests;

import com.example.models.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class DeleteContactFromFormTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().getContactList().size() == 0) {
            app.contact().create(new ContactData().withFirstName("Anna").withLastName("Smith").withAddress("Test Address").withEmail("ann@mail.com").withPhone("895678567857"));
        }
    }

    @Test

    //Deletes a contact via the contact modification form
    public void editContactsTest() {

        List<ContactData> before = app.contact().getContactList();
        int index = before.size() - 1;
        app.contact().deleteFromForm(index);
        List<ContactData> after = app.contact().getContactList();
        assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        assertEquals(before, after);
    }

}
