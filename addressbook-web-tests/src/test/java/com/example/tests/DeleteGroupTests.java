package com.example.tests;

import org.testng.annotations.Test;

public class DeleteGroupTests extends TestBase {

    @Test
    public void deleteGroupTest() {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().ReturnToGroupPage();
    }
}
