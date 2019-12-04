package com.example.pottypoll;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class userDB_test {
    user u;
    @Before
    public void setUp() throws Exception {
        u = new user();
    }

    @Test
    public void addUser_correct() {
        assertTrue(u.addUserToDatabase("bob", "name@email.com", "password", 0));
    }
    @Test
    public void addUser_correctdup() {
        assertFalse(u.addUserToDatabase("bob", "name@email.com", "asdf", 0));
    }

    @Test
    public void addUser_wrongemail() {
        assertFalse(u.addUserToDatabase("tim", "name", "password", 0));
    }

    @Test
    public void addUser_nulluser() {
        assertFalse(u.addUserToDatabase(null, "name@gmail.com", "password", 0));
    }

    @Test
    public void login_correct() {
        assertTrue(u.logIn("bob",  "password"));
    }

    @Test
    public void login_wrongpass() {
        assertFalse(u.logIn("bob",  "fuck"));
    }

    @Test
    public void login_nulluser() {
        assertFalse(u.logIn(null,  "password"));
    }

    @Test
    public void login_usernonexistent() {
        assertFalse(u.logIn("joe",  "password"));
    }

    @Test
    public void logged_in() {
        u.logIn("bob",  "password");
        assertTrue(u.getLoginStatus());
    }

    @Test
    public void logged_out() {
        u.logout();
        assertFalse(u.getLoginStatus());
    }
}
