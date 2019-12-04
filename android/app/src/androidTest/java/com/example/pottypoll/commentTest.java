package com.example.pottypoll;
import android.content.Context;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class commentTest {
    user u;
    restroom r;
    comment c;
    CommentAdaptor database;
    @Before
    public void SetUp() {
        r = new restroom();
        u = new user();
        c = new comment();
        database = new CommentAdaptor(ApplicationProvider.getApplicationContext());
        u.addUserToDatabase("bob", "name@email.com", "password", 1);
        u.logIn("bob", "password");
        r.addRestroom(u.getID(), "male", "Benedum", 0, 0, "Bathroom", 1, "24 hours", 1, 1, 1);
    }

    @Test
    public void createEmptyComment() {
        assertTrue(c.addComment(r.getID(), u.getID(), 4, ""));
    }

    @Test
    public void createComment() {
        assertTrue(c.addComment(r.getID(), u.getID(), 3, "asdfasdfad"));
    }

    @Test
    public void createComment_loggedout() {
        user loggedout = new user();
        assertFalse(c.addComment(r.getID(), loggedout.getID(), 3, "asdfasdfad"));
    }

    @Test
    public void invalidrating() {
        assertFalse(c.addComment(r.getID(), u.getID(), 1000, ""));
    }

    @Test
    public void upvote() {
        System.out.println("Helpful = "+c.getHelpful());
        c.addComment(r.getID(), u.getID(), 4, "");
        c.setHelpful();
        ArrayList<CommentStruct> list = database.getCommentArray(c.getBathroomID());
        for (CommentStruct com:list)
            System.out.println("Helpful = "+com.HELPFUL);
    }

    @Test
    public void editcomment() {
        c.addComment(r.getID(), u.getID(), 4, "");
        c.editComment(u.getID(), "Hello World!");
        ArrayList<CommentStruct> list = database.getCommentArray(c.getBathroomID());
        for (CommentStruct com:list) {
            System.out.println("Comment = " + com.TEXT);
            assertEquals(com.TEXT, "Hello World!");
        }
    }

    @Test
    public void editcomment_wronguser() {
        c.addComment(r.getID(), u.getID(), 4, "");
        c.editComment(5651, "Hello World!");
        ArrayList<CommentStruct> list = database.getCommentArray(c.getBathroomID());
        for (CommentStruct com:list) {
            System.out.println("Comment = " + com.TEXT);
            assertEquals(com.TEXT, "");
        }
    }
}