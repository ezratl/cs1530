package com.example.pottypoll;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class BathroomAdaptor
{
    BathroomHelper helper;
    public BathroomAdaptor(Context context)
    {
        helper = new BathroomAdaptor.BathroomHelper(context);
    }

    //getters
    public String getBathroom(int bathroomID) //Get all the members of a bathroom with a given ID
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] columns = {BathroomHelper.COLUMN_AUTHOR, BathroomHelper.COLUMN_GENDER, BathroomHelper.COLUMN_SHOWER, BathroomHelper.COLUMN_SINK, BathroomHelper.COLUMN_PAPERTOWELS,
                BathroomHelper.COLUMN_ACTIVE, BathroomHelper.COLUMN_LOCATION, BathroomHelper.COLUMN_XCORD, BathroomHelper.COLUMN_YCORD, BathroomHelper.COLUMN_BUILDNAME,
                BathroomHelper.COLUMN_FLOOR, BathroomHelper.COLUMN_HOURS, BathroomHelper.COLUMN_RATING, BathroomHelper.COLUMN_RATERS, BathroomHelper.COLUMN_DATE};
        Cursor cursor = db.query(BathroomHelper.TABLE_NAME, columns, BathroomHelper.COLUMN_ID + " = '" + bathroomID + "'", null, null, null, null);
        StringBuffer output = new StringBuffer();
        while (cursor.moveToNext()) //this should not loop
        {
            int cauthor = cursor.getColumnIndex(BathroomHelper.COLUMN_AUTHOR);
            int uauthor = cursor.getInt(cauthor);

            int cgender = cursor.getColumnIndex(BathroomHelper.COLUMN_GENDER);
            String ugender = cursor.getString(cgender);

            int cshower = cursor.getColumnIndex(BathroomHelper.COLUMN_SHOWER);
            int ushower = cursor.getInt(cshower);

            int csink = cursor.getColumnIndex(BathroomHelper.COLUMN_SINK);
            int usink = cursor.getInt(csink);

            int cpapertowels = cursor.getColumnIndex(BathroomHelper.COLUMN_PAPERTOWELS);
            int upapertowels = cursor.getInt(cpapertowels);

            int cactive = cursor.getColumnIndex(BathroomHelper.COLUMN_ACTIVE);
            int uactive = cursor.getInt(cactive);

            int clocation = cursor.getColumnIndex(BathroomHelper.COLUMN_LOCATION);
            String ulocation = cursor.getString(clocation);

            int cxcord = cursor.getColumnIndex(BathroomHelper.COLUMN_XCORD);
            double uxcord = cursor.getDouble(cxcord);

            int cycord = cursor.getColumnIndex(BathroomHelper.COLUMN_YCORD);
            double uycord = cursor.getDouble(cycord);

            int cbuildname = cursor.getColumnIndex(BathroomHelper.COLUMN_BUILDNAME);
            String ubuildname = cursor.getString(cbuildname);

            int cfloor = cursor.getColumnIndex(BathroomHelper.COLUMN_FLOOR);
            int ufloor = cursor.getInt(cfloor);

            int chours = cursor.getColumnIndex(BathroomHelper.COLUMN_HOURS);
            String uhours = cursor.getString(chours);

            int crating = cursor.getColumnIndex(BathroomHelper.COLUMN_RATING);
            int urating = cursor.getInt(crating);

            int craters = cursor.getColumnIndex(BathroomHelper.COLUMN_RATERS);
            int uraters = cursor.getInt(craters);

            int cdate = cursor.getColumnIndex(BathroomHelper.COLUMN_DATE);
            int udate = cursor.getInt(cdate);

            output.append(uauthor + " " + ugender + " " + ushower + " " + usink + " " + upapertowels + " " +  uactive + " " + ulocation + " " + uxcord + " " + uycord + " " + ubuildname + " " + ufloor + " " + uhours + " " +  urating + " " + uraters + " " + udate + " " +"\n");
        }
        return output.toString(); //UID LOCATION then next line then UID LOCATION

    }

    public ArrayList getBathroomArray() //Get all the members of a bathroom with a given ID
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] columns = {BathroomHelper.COLUMN_ID, BathroomHelper.COLUMN_AUTHOR, BathroomHelper.COLUMN_GENDER, BathroomHelper.COLUMN_SHOWER, BathroomHelper.COLUMN_SINK, BathroomHelper.COLUMN_PAPERTOWELS,
                BathroomHelper.COLUMN_ACTIVE, BathroomHelper.COLUMN_LOCATION, BathroomHelper.COLUMN_XCORD, BathroomHelper.COLUMN_YCORD, BathroomHelper.COLUMN_BUILDNAME,
                BathroomHelper.COLUMN_FLOOR, BathroomHelper.COLUMN_HOURS, BathroomHelper.COLUMN_RATING, BathroomHelper.COLUMN_RATERS, BathroomHelper.COLUMN_DATE};
        Cursor cursor = db.query(BathroomHelper.TABLE_NAME, columns, null, null, null, null, null);
        ArrayList output = new ArrayList();
        BathroomStruct temp;
        while (cursor.moveToNext()) //this should not loop
        {
            int cid = cursor.getColumnIndex(BathroomHelper.COLUMN_ID);
            int uid = cursor.getInt(cid);

            int cauthor = cursor.getColumnIndex(BathroomHelper.COLUMN_AUTHOR);
            int uauthor = cursor.getInt(cauthor);

            int cgender = cursor.getColumnIndex(BathroomHelper.COLUMN_GENDER);
            String ugender = cursor.getString(cgender);

            int cshower = cursor.getColumnIndex(BathroomHelper.COLUMN_SHOWER);
            int ushower = cursor.getInt(cshower);

            int csink = cursor.getColumnIndex(BathroomHelper.COLUMN_SINK);
            int usink = cursor.getInt(csink);

            int cpapertowels = cursor.getColumnIndex(BathroomHelper.COLUMN_PAPERTOWELS);
            int upapertowels = cursor.getInt(cpapertowels);

            int cactive = cursor.getColumnIndex(BathroomHelper.COLUMN_ACTIVE);
            int uactive = cursor.getInt(cactive);

            int clocation = cursor.getColumnIndex(BathroomHelper.COLUMN_LOCATION);
            String ulocation = cursor.getString(clocation);

            int cxcord = cursor.getColumnIndex(BathroomHelper.COLUMN_XCORD);
            double uxcord = cursor.getDouble(cxcord);

            int cycord = cursor.getColumnIndex(BathroomHelper.COLUMN_YCORD);
            double uycord = cursor.getDouble(cycord);

            int cbuildname = cursor.getColumnIndex(BathroomHelper.COLUMN_BUILDNAME);
            String ubuildname = cursor.getString(cbuildname);

            int cfloor = cursor.getColumnIndex(BathroomHelper.COLUMN_FLOOR);
            int ufloor = cursor.getInt(cfloor);

            int chours = cursor.getColumnIndex(BathroomHelper.COLUMN_HOURS);
            String uhours = cursor.getString(chours);

            int crating = cursor.getColumnIndex(BathroomHelper.COLUMN_RATING);
            int urating = cursor.getInt(crating);

            int craters = cursor.getColumnIndex(BathroomHelper.COLUMN_RATERS);
            int uraters = cursor.getInt(craters);

            int cdate = cursor.getColumnIndex(BathroomHelper.COLUMN_DATE);
            int udate = cursor.getInt(cdate);

            temp = new BathroomStruct(uid, uauthor, ugender, ushower, usink, upapertowels,  uactive, ulocation, uxcord,  uycord,  ubuildname, ufloor, uhours, urating,  uraters, udate);
            output.add(temp);
        }
        return output; //UID LOCATION then next line then UID LOCATION

    }

    public String getBathroomIDs() //returns all bathroom IDs
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        String[] columns={BathroomHelper.COLUMN_ID};
        Cursor cursor = db.query(BathroomHelper.TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer output = new StringBuffer();
        while(cursor.moveToNext()) //this should  loop
        {
            int cid = cursor.getColumnIndex(BathroomHelper.COLUMN_ID);
            int uid = cursor.getInt(cid);
            output.append(uid + "\n");
        }
        return output.toString();


    }

    public int getRating(int uid) //returns -1 on error
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        String[] columns={BathroomHelper.COLUMN_RATING};
        Cursor cursor = db.query(BathroomHelper.TABLE_NAME, columns, BathroomHelper.COLUMN_ID+" = '"+uid+"'", null, null, null, null);
        int value = -1;
        while(cursor.moveToNext()) //this shouldn't ever loop
        {
            int cname = cursor.getColumnIndex(BathroomHelper.COLUMN_RATING);
            value = cursor.getInt(cname);
        }
        return value;
    }
    public int getRaters(int uid) //returns -1 on error
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        String[] columns={BathroomHelper.COLUMN_RATERS};
        Cursor cursor = db.query(BathroomHelper.TABLE_NAME, columns, BathroomHelper.COLUMN_ID+" = '"+uid+"'", null, null, null, null);
        int value = -1;
        while(cursor.moveToNext()) //this shouldn't ever loop
        {
            int cname = cursor.getColumnIndex(BathroomHelper.COLUMN_RATERS);
            value = cursor.getInt(cname);
        }
        return value;
    }

    //insert
    public long insertData(int userID, String gender, String address, double xcoord, double ycoord, String name, int floor, String hours, int shower, int sink, int papertowels) //returns ID if successful, is - on failure
    {
        SQLiteDatabase db =helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //data to store

        contentValues.put(BathroomHelper.COLUMN_AUTHOR, userID);
        contentValues.put(BathroomHelper.COLUMN_LOCATION, address );
        contentValues.put(BathroomHelper.COLUMN_XCORD, xcoord );
        contentValues.put(BathroomHelper.COLUMN_YCORD, ycoord );
        contentValues.put(BathroomHelper.COLUMN_GENDER, gender);
        contentValues.put(BathroomHelper.COLUMN_BUILDNAME, name );
        contentValues.put(BathroomHelper.COLUMN_FLOOR, floor);
        contentValues.put(BathroomHelper.COLUMN_HOURS, hours);
        contentValues.put(BathroomHelper.COLUMN_SHOWER, shower);
        contentValues.put(BathroomHelper.COLUMN_SINK, sink);
        contentValues.put(BathroomHelper.COLUMN_PAPERTOWELS, papertowels);
        contentValues.put(BathroomHelper.COLUMN_RATERS, 0);
        contentValues.put(BathroomHelper.COLUMN_RATING, 0);
        contentValues.put(BathroomHelper.COLUMN_ACTIVE, 1);
        contentValues.put(BathroomHelper.COLUMN_DATE, 0);

        return db.insert(BathroomAdaptor.BathroomHelper.TABLE_NAME, null, contentValues);
    }

    //modify
    public void addRating(int uid)
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(BathroomHelper.COLUMN_RATING, getRating(uid) + 1);

        db.update(BathroomHelper.TABLE_NAME, contentValues, BathroomHelper.COLUMN_ID+" = '"+uid+"'", null );

    }

    public void addRater(int uid)
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(BathroomHelper.COLUMN_RATERS, getRaters(uid) + 1);

        db.update(BathroomHelper.TABLE_NAME, contentValues, BathroomHelper.COLUMN_ID+" = '"+uid+"'", null );

    }

    //delete
    public void deleteBathroom(int ID) //delete bathroom with given ID
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        db.delete(BathroomHelper.TABLE_NAME, BathroomHelper.COLUMN_ID+" = '"+ID+"'", null);
    }

    static class BathroomHelper extends SQLiteOpenHelper
    {
        private static final int DATABASE_VERSION = 2;
        private static final String DATABASE_NAME = "PP_BathroomDB";
        private static final String TABLE_NAME = "PP_Bathroom";
        private static final String COLUMN_ID = "_id"; //autoincrementing int
        private static final String COLUMN_AUTHOR = "UserID";   //int
        private static final String COLUMN_GENDER = "Gender"; //varchar
        private static final String COLUMN_SHOWER = "Shower"; //int 0 or 1
        private static final String COLUMN_SINK = "Sink"; //int 0 or 1
        private static final String COLUMN_PAPERTOWELS = "PaperTowels"; //int 0 or 1
        private static final String COLUMN_ACTIVE = "Active"; //int 0 ir 1
        private static final String COLUMN_LOCATION = "Address"; //varchar
        private static final String COLUMN_XCORD = "Coord1"; //real
        private static final String COLUMN_YCORD = "Coord2";   //real
        private static final String COLUMN_BUILDNAME = "Name"; //varchar
        private static final String COLUMN_FLOOR = "Floor"; //int
        private static final String COLUMN_HOURS = "Hours"; //varchar
        private static final String COLUMN_RATING = "Rating"; //int
        private static final String COLUMN_RATERS = "Raters"; //number of ratings already, so we can just add the new one without recalculating
        private static final String COLUMN_DATE = "DateCreated"; //int
        private Context context;

        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_LOCATION + " VARCHAR(250), "+COLUMN_XCORD + " REAL, "+COLUMN_YCORD + " REAL, "+COLUMN_BUILDNAME + " VARCHAR(250), "+COLUMN_FLOOR + " INTEGER, "+COLUMN_HOURS + " VARCHAR(250), " + COLUMN_AUTHOR + " INTEGER, " + COLUMN_DATE + " INTEGER, " + COLUMN_GENDER + " VARCHAR(25), " +COLUMN_RATING + " INTEGER, "+COLUMN_SHOWER + " INTEGER, "+COLUMN_SINK + " INTEGER, "+COLUMN_PAPERTOWELS + " INTEGER, "+COLUMN_ACTIVE + " INTEGER, "+ COLUMN_RATERS + " INTEGER);";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

        //SQLiteDatabase database;

        public BathroomHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try
            {
                db.execSQL(CREATE_TABLE);
            }
            catch (SQLiteException e)
            {
                //throw a user friendly error
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1)
        {
            try
            {
                db.execSQL(DROP_TABLE); //delete it
                onCreate(db);           //make it again
            }
            catch (SQLiteException e)
            {
                //throw a user friendly error
            }
        }

    }


}

