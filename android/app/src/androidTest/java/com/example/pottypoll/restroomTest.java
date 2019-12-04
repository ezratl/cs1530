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
public class restroomTest {
    restroom r;
    user u;
    BathroomAdaptor database;
    @Before
    public void setUp() {
        r = new restroom();
        u = new user();
        database = new BathroomAdaptor(ApplicationProvider.getApplicationContext());
        u.addUserToDatabase("bob", "name@email.com", "password", 1);
        u.logIn("bob", "password");
    }
    @Test
    public void addRestroomCorrect() {
        assertTrue(r.addRestroom(u.getID(), "male", "Benedum", 0, 0, "Bathroom", 1, "24 hours", 1, 1, 1));
    }

    @Test
    public void getExisting () {
        r.addRestroom(u.getID(), "male", "Cathy", 1, 0, "Bathroom", 2, "24 hours", 0, 1, 1);
        int idCheck = r.getID();
        System.out.println(database.getBathroom(idCheck));
        assertTrue(database.getBathroom(idCheck).length()>0);
    }

    @Test
    public void removeExisting() {
        int idCheck = r.getID();
        System.out.println(database.getBathroom(idCheck));
        r.deleteBathroom();
        assertEquals(database.getBathroom(idCheck), "");
    }

    @Test
    public void allSaved() {
        r.addRestroom(u.getID(), "male", "Cathy", 1, 0, "Bathroom", 2, "24 hours", 0, 1, 1);
        r.addRestroom(u.getID(), "female", "Lawrence", 1, 0, "Bathroom", 2, "24 hours", 0, 1, 1);
        r.addRestroom(u.getID(), "male", "Posvar", 1, 0, "Bathroom1", 2, "24 hours", 0, 1, 0);
        ArrayList<BathroomStruct> list = database.getBathroomArray();
        assertTrue(list.size()>1);
        for(BathroomStruct br:list)
            System.out.println(br.ID+" : "+br.LOCATION);
    }

    @Test
    public void flagBathroom() {

    }

}