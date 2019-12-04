package com.example.pottypoll;

import org.junit.Test;
import static org.junit.Assert.*;


public class userTest {
    user u = new user();
    @Test
    public void user() {
    }

    @Test
    public void setLocation() {
        u.setLongitude(200);
        u.setLatitude(260);
        int[] expected = {200,260};
        assertArrayEquals(u.getLocation(),expected);
    }

    @Test
    public void validEmail_CorrectEmail() {
        assertTrue(user.validEmail("name@email.com"));
    }

    @Test
    public void validEmail_noAt() {
        assertFalse(user.validEmail("name.com"));
    }

    @Test
    public void validEmail_noDot() {
        assertFalse(user.validEmail("name@email"));
    }

    @Test
    public void validEmail_nothing() {
        assertFalse(user.validEmail("asd"));
    }

}