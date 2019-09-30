package com.example.tests;

import com.example.models.GroupData;
import org.testng.annotations.Test;

public class EditGroupTests extends TestBase {

    @Test
    public void editGroupTest() throws Exception {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().editGroup();
        app.getGroupHelper().fillGroupForm(new GroupData("sample", "group", "name"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().ReturnToGroupPage();
    }
}
