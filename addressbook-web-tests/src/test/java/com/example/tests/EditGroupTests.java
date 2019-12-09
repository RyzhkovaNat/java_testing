package com.example.tests;

import com.example.models.GroupData;
import com.example.models.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class EditGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size()==0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1").withHeader("header1").withFooter("footer1"));
        }
    }

    @Test
    public void editGroupTest() {
        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("sample").withHeader("group").withFooter("name");
        app.goTo().groupPage();
        app.group().modify(group);
        Groups after = app.db().groups();
        assertThat(after.size(),  equalTo(before.size()));
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    }
}
