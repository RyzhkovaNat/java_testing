package com.example.tests;

import com.example.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteGroupTests extends TestBase {

    @Test
    public void deleteGroupTest() {
        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test10", "testheader", "testfooter"));
        }
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before - 1);
    }
}
