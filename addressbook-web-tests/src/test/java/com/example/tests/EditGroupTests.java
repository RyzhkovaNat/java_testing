package com.example.tests;

import com.example.models.GroupData;
import org.testng.annotations.Test;

public class EditGroupTests extends TestBase {

    @Test
    public void editGroupTest() {
        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test10", "testheader", "testfooter"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().editGroup();
        app.getGroupHelper().fillGroupForm(new GroupData("sample", "group", "name"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
