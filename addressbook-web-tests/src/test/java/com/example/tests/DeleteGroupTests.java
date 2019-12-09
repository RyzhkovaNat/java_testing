package com.example.tests;

import com.example.models.GroupData;
import com.example.models.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class DeleteGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.db().groups().size()==0) {
            app.group().create(new GroupData().withName("test2").withFooter("F").withHeader("H"));
        }
    }


    @Test
    public void deleteGroupTest() {
        Groups before = app.db().groups();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        Groups after = app.db().groups();
        assertThat(after.size(), equalTo(before.size() - 1));
        assertThat(after, equalTo(before.without(deletedGroup)));
    }

}
