package com.example.tests;

import com.example.models.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testAddGroup() {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("test10", "testheader", "testfooter"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().ReturnToGroupPage();
    }
}
