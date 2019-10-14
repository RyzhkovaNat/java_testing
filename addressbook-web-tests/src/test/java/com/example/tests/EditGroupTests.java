package com.example.tests;

import com.example.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class EditGroupTests extends TestBase {

    @Test
    public void editGroupTest() {
        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test10", "testheader", "testfooter"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().editGroup();
        app.getGroupHelper().fillGroupForm(new GroupData("sample", "group", "name"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());
    }
}
